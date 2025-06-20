import pandas as pd

def extract_test_info(csv_file, output_file="filtered_tests.csv"):
    """Reads a CSV file and extracts only the id, project, and test_name columns."""
    
    # Read the CSV file
    df = pd.read_csv(csv_file)
    
    # Extract relevant columns
    filtered_df = df[['id', 'project', 'test_name']]
    
    # Display the extracted data
    print(filtered_df)
    
    # Save the extracted data to a new CSV file
    filtered_df.to_csv(output_file, index=False)
    print(f"Extracted data saved to {output_file}")

def analyze_projects_and_categories(csv_file):
    """Reads a CSV file, extracts unique project names, and counts tests per category for each project."""
    df = pd.read_csv(csv_file)
    print('len(df)=',len(df))

    # Extract unique project names
    unique_projects = df["project"].unique()

    # Count the number of tests per category for each project
    project_category_counts = df.groupby(["project", "category"]).size().unstack(fill_value=0)

    # Print and save unique projects
    print("Unique Projects:", unique_projects)
    with open("unique_projects.txt", "w") as f:
        for project in unique_projects:
            f.write(project + "\n")
    
    # Save category counts per project to a CSV file
    output_file = "project_category_counts.csv"
    project_category_counts.to_csv(output_file)

    # Calculate the number of unique projects per category
    projects_per_category = df.groupby("category")["project"].nunique()
    
    print("Number of unique projects per flaky test category:")
    print(projects_per_category)

    projects_per_category.to_csv("projects_per_category.csv")


    print(f"Category-wise test counts per project saved to {output_file}")


# Example usage
csv_file = "Flakicat/Flakicat_dataset_with_nonflaky_indented.csv" #"your_csv_file.csv"  # Replace with the actual file path
#get_unique_projects(csv_file)
#analyze_projects_and_categories(csv_file)
extract_test_info(csv_file)


