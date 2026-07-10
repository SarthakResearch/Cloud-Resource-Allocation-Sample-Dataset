# Cloud-Resource-Allocation-Sample-Dataset-for-Multi-Constraint-User's-Tasks-for-Preference-Aware-Auction-Model-Research


This repository contains a synthetically generated benchmark dataset representing IoT task requests and heterogeneous cloud Virtual Machine (VM) offerings, intended for use in research on cloud resource allocation, task scheduling, and auction-based resource provisioning in IoT-cloud environments.

The dataset consists of two categories of CSV files: **Task Datasets**, describing IoT task requests submitted by users, and **VM Datasets**, describing computational resources offered by cloud service providers.

## Repository Contents

### Task Datasets

Five task datasets are provided, each representing a different task load:

- `TaskDataset50.csv`
- `TaskDataset100.csv`
- `TaskDataset150.csv`
- `TaskDataset200.csv`
- `TaskDataset250.csv`

Each file contains a header row followed by task records with the following attributes, in order:

| Column | Attribute | Description |
|---|---|---|
| 1 | ID | Unique task identifier |
| 2 | Length | Task length, in Million Instructions (MI) |
| 3 | Budget | Maximum cost the user is willing to pay for task execution, in cost units |
| 4 | Deadline | Maximum allowable execution time for the task, in seconds |
| 5 | Preference | Relative priority between deadline and budget when both cannot be simultaneously satisfied. Stored as a single character: `T` indicates deadline (time) priority, and `C` indicates budget (cost) priority |

### VM Datasets

Five VM datasets are provided, each representing a different resource pool size:

- `25VmDataset.csv`
- `50VmDataset.csv`
- `75VmDataset.csv`
- `100VmDataset.csv`
- `150VmDataset.csv`

Each file contains a header row followed by VM records with the following attributes, in order:

| Column | Attribute | Description |
|---|---|---|
| 1 | ID | Unique VM identifier |
| 2 | MIPS | Processing capacity of the VM, in Million Instructions Per Second |
| 3 | Rate | Usage rate charged by the provider, in cost units per second |
| 4 | Reputation | Reserved field for provider/VM reputation or reliability score. This field is not currently populated with meaningful values and is included to support future feedback- or reputation-based resource allocation studies |

## Sample Parsing Code

A sample Java parsing utility, `ImportDataset.java`, is included in this repository to demonstrate how the CSV files can be read and loaded into memory. It provides two methods:

- `importTaskDataset()` — reads a Task Dataset CSV file, skips the header row, and parses each record into task ID, length, budget, deadline, and preference fields.
- `importVmDataset()` — reads a VM Dataset CSV file, skips the header row, and parses each record into VM ID, MIPS, rate, and reputation fields.

Note that the file paths in the sample code are hardcoded to a local directory structure and will need to be updated to point to the appropriate dataset file location before use. The parsing logic itself can be adapted to any programming language or environment as needed.

## Notes

- Task and VM attribute value ranges are independently drawn within fixed bounds representative of small-to-medium-scale IoT-cloud workloads and are consistent across all provided files.
- This dataset is provided as a standalone, general-purpose benchmark for IoT-cloud task and VM allocation research and is not tied to any specific study.
