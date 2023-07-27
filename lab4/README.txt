Course: CS-102
Semester: Fall 2022
Assignment: Lab04
Author: Sumeyye Acar
Id: 22103640



In this project one can;
-Create a new Map or use the given Map (Map.txt) --> Map Map(int y, int x) or Map Map(String filename)
-Create new Paths or use the given Paths (in the "Sample Paths" folder) --> Path createPath() or embedded methods of the Map Class
-Check all moves of a path for any map individualy (can this move happen?, is there a block?) --> boolean isMovePossible( path.getPath(), int numberOfTheMove )
-Check any path for any map individualy (will this path lead to a treasure?) --> boolean isPathToTreasure( path.getPath() )
-Check any combination of paths for any map (does this combination lead to treasure?) -- > boolean checkPathCombination( Path a, Path b )
-Display which combinations of all combinations of all paths for any map is leading to treasure (which ones lead to treasure?) --> void processPathCombinations()
-Display which paths lead to tresure for any map -- > void processAllPaths()