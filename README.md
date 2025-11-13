# MST Edge Removal and Replacement

## Overview

This project demonstrates an efficient algorithm for handling edge removal from a Minimum Spanning Tree (MST) and finding a replacement edge to maintain the MST property.

## Features

- **MST Construction**: Implements Kruskal's algorithm using Union-Find data structure
- **Edge Removal**: Removes an edge from the MST and identifies resulting components
- **Replacement Edge**: Efficiently finds the minimum-weight edge to reconnect the components
- **Visual Output**: Clear console output showing each step of the process

## Project Structure

```
mst-edge-removal/
├── src/
│   └── main/
│       └── java/
│           └── mst/
│               ├── Edge.java              # Edge representation
│               ├── Graph.java             # Graph and MST algorithms
│               ├── UnionFind.java         # Union-Find data structure
│               └── MSTEdgeRemoval.java    # Main demonstration class
├── compile.bat                            # Windows compilation script
├── compile.sh                             # Unix/Linux/Mac compilation script
├── run.bat                                # Windows run script
├── run.sh                                 # Unix/Linux/Mac run script
├── .gitignore                             # Git ignore file
└── README.md                              # This file
```

## How It Works

### Algorithm Steps

1. **Build MST**: Uses Kruskal's algorithm with Union-Find to construct the initial MST
2. **Remove Edge**: Removes a selected edge from the MST, splitting it into two components
3. **Find Components**: Identifies which vertices belong to each component after removal
4. **Find Replacement**: Searches for the minimum-weight edge that reconnects the two components
5. **Display New MST**: Shows the updated MST with the replacement edge

### Time Complexity

- **MST Construction**: O(E log E) where E is the number of edges
- **Edge Removal**: O(1)
- **Component Finding**: O(V + E') where V is vertices and E' is MST edges
- **Replacement Edge**: O(E) in the worst case

## Requirements

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

## Installation

### Clone the Repository

```bash
git clone https://github.com/rafaeldo7/MSTEdgeRemoval
cd MSTEdgeRemoval
```

## Running the Program

### Option 1: Using Scripts (Recommended)

#### On Windows:

```batch
compile.bat
run.bat
```

#### On Linux/Mac/Unix:

```bash
chmod +x compile.sh run.sh
./compile.sh
./run.sh
```

### Option 2: Manual Compilation and Execution

#### Compile:

```bash
javac -d out src/main/java/mst/*.java
```

#### Run:

```bash
java -cp out mst.MSTEdgeRemoval
```

## Example Output

```
======================================================================
MST Edge Removal and Replacement Demonstration
======================================================================

Sample Graph Created:
Vertices: 6 (labeled 0-5)
Edges:
  (0 - 1, weight: 4)
  (0 - 2, weight: 3)
  ...

STEP 1: Building Minimum Spanning Tree (MST)
----------------------------------------------------------------------
MST Edges:
  1. (1 - 2, weight: 1)
  2. (1 - 3, weight: 2)
  3. (3 - 4, weight: 2)
  ...
Total MST Weight: 15

STEP 2: Removing Edge from MST
----------------------------------------------------------------------
Removed edge: (3 - 4, weight: 2)

STEP 3: Finding Components After Edge Removal
----------------------------------------------------------------------
Number of components: 2
  Component 1: [0, 1, 2, 3]
  Component 2: [4, 5]

STEP 4: Finding Replacement Edge
----------------------------------------------------------------------
Replacement edge found: (4 - 5, weight: 3)

STEP 5: New MST After Reconnection
----------------------------------------------------------------------
MST Edges:
  1. (1 - 2, weight: 1)
  2. (1 - 3, weight: 2)
  ...
Total MST Weight: 16

======================================================================
SUMMARY
======================================================================
Original MST weight: 15
New MST weight:      16
Edge removed:        (3 - 4, weight: 2)
Edge added:          (4 - 5, weight: 3)
======================================================================
```

## Implementation Details

### Edge Class
Represents a weighted edge with source, destination, and weight. Implements `Comparable` for sorting by weight.

### UnionFind Class
Implements the Union-Find (Disjoint Set Union) data structure with:
- **Path Compression**: Optimizes find operations
- **Union by Rank**: Keeps trees balanced

### Graph Class
Manages the graph structure and provides:
- MST construction using Kruskal's algorithm
- Component detection after edge removal
- Replacement edge finding

### MSTEdgeRemoval Class
Main class that demonstrates the complete workflow with a sample graph.



## Testing

The program includes a sample graph with 6 vertices and 9 edges. The graph is designed to demonstrate:
- Multiple possible MSTs
- Clear component separation after edge removal
- Multiple candidate replacement edges



## Author

Rafael Shayekhov


