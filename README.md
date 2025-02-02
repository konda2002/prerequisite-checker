# Prerequisite Checker

## Overview
This project implements a **Prerequisite Checker** system that verifies whether a user has completed the necessary prerequisites before taking a specific course. It helps students plan their coursework efficiently and ensures proper learning progression.

## Features
- **Graph-based Prerequisite Verification**
- **Course Dependency Analysis**
- **Efficient Path Checking Algorithm**
- **Python-based Implementation**

## Tech Stack
- **Python**
- **Graph Data Structures**
- **NetworkX (Optional - for visualization)**
- **Pandas & NumPy** (Data Handling)

## Installation & Setup
### Prerequisites
Ensure you have Python 3.8+ installed.

### Step 1: Clone the Repository
```sh
git clone https://github.com/konda2002/prerequisite-checker.git
cd prerequisite-checker/PreReqChecker
```

### Step 2: Install Dependencies
```sh
pip install -r requirements.txt
```
If `requirements.txt` is missing, install manually:
```sh
pip install pandas numpy
```

### Step 3: Run the Script
```sh
python PreReqChecker.py
```

## Usage
1. Define the **course prerequisites** as a dependency graph.
2. Input a **course name** and check if prerequisites are met.
3. If prerequisites are missing, the system suggests the required courses.

## Algorithm Details
- **Graph Representation**: Courses are represented as a directed graph.
- **Path Checking**: Uses graph traversal to verify prerequisites.
- **Topological Sorting**: Helps detect course dependency cycles.

## Results
- The system accurately checks if a student meets the **required prerequisites**.
- Helps students **plan coursework effectively**.

## Future Improvements
- Enhance visualization with **Graph Plotting (NetworkX)**.
- Add **a web-based UI** for easier user interaction.
- Optimize algorithms for **faster prerequisite validation**.

## License
This project is open-source under the MIT License.

## Contact
For questions or collaborations, reach out at **[Your Email]** or check the repository at **[GitHub Repo](https://github.com/konda2002/prerequisite-checker)**.

