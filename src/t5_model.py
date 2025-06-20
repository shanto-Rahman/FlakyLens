import torch
from torch import nn
from transformers import T5EncoderModel, T5Config, T5Model

class T5_Arch(nn.Module):
    def __init__(self, auto_model, output_layer):
        super(T5_Arch, self).__init__()
        # Assuming `auto_model` is a pre-initialized T5EncoderModel
        self.t5 = auto_model
        self.fc = nn.Linear(self.t5.config.hidden_size, output_layer)  # T5 base model has a hidden size of 768
        self.softmax = nn.LogSoftmax(dim=-1)

    def forward(self, input_ids, attention_mask=None):
        # T5 returns tuple, where first item is last hidden states
        output = self.t5(input_ids=input_ids, attention_mask=attention_mask)
        last_hidden_states = output.last_hidden_state

        # You might want to use only the output from the first token (similar to BERT's [CLS] token)
        # or apply pooling strategies across all tokens depending on your approach
        cls_output = last_hidden_states[:, 0, :]  # Get the first token's embeddings

        output = self.fc(cls_output)
        output = self.softmax(output)

        return output

