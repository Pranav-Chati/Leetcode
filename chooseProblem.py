import random

problems = {
    "Sliding Window": [
        "1. Introduction",
        "2. Maximum Sum Subarray of Size K",
        "3. Smallest Subarray with given sum",
        "4. Longest Substring with K Distinct Characters",
        "5. Fruits into basket",
        "6. no-repeat substring",
        "7. Longest Substring with Same Letters after Replacement",
        "8. Longest Subarray with Ones after Replacement",
    ],
    "Two Pointers": [
        "1. pair with target sum",
        "2. Remove Duplicates",
        "3. Squaring a sorted array",
        "4. Triplet sum to zero",
        "5. triplet sum close to target",
        "6. Triplets with Smaller Sum",
        "7. Dutch National Problem",
    ],
    "Fast Slow Pointers": [
        "1. LinkedList Cycle",
        "2. Start of LL Cycle",
        "3. Happy Number",
        "4. Middle of LL",
        "5. Problem Challenge 1 - Palindrome LL",
        "6. Problem Challenge 2 - Rearrange a LL",
    ],
    "Merge Intervals": [
        "1. Merged Intervals",
        "2. Insert Interval",
        "3. Intervals Intersection",
        "4. Conflicting Appointments",
    ],
    "Cyclic Sort": [
        "1. Cyclic Sort",
        "2. Find the missing number",
        "3. Find all missing numbers",
        "4. Find the duplicate number",
        "5. Problem Challenge 1 - Find the Corrupt Pair",
        "6. Problem Challenge 2 - Find the Smallest Missing Positive Number",
    ],
    "InPlaceReversalLinkedList": [
        "1. Reverse a LinkedList",
        "2. Reverse a Sub-list",
        "3. Reverse every K-element Sub-list",
        "4. Problem Challenge 1 - Reverse alternating K-element Sub-list",
    ],
    "Tree Breadth First Search": [
        "1. Binary Tree Level Order Traversal",
        "2. Reverse Level Order Traversal",
        "3. Zigzag Traversal",
        "4. Level Averages in a Binary Tree",
        "5. Minimum Depth of a Binary Tree",
        "6. Level Order Successor",
        "7. Connect Level Order Siblings",
        "8. Problem Challenge 1 - Connect All Level Order Siblings",
        "9. Problem Challenge 2 - Right View of a Binary Tree",
    ],
    "Tree Depth First Search": [
        "1. Binary Tree Path Sum",
        "2. All Paths for a Sum",
        "3. Sum of Path Numbers",
        "4. Path With Given Sequence",
        "5. Count Paths for a Sum",
        "6. Problem Challenge 1 - Tree Diameter",
        "7. Problem Challenge 2 - Path with Maximum Sum",
    ],
    "Modified Binary Search": [
        "1. Order-agnostic Binary Search",
    ],
    "Knapsack": [
        "1. 0/1 Knapsack",
        "2. Equal Subset Sum Partition",
        "3. Subset Sum",
    ],
}


def merge_and_shuffle_with_categories(categories):
    merged_list = []
    for category, problems in categories.items():
        for problem in problems:
            merged_list.append(
                (category, problem[3:])
            )  # Remove the first three characters

    random.shuffle(merged_list)

    for idx, (category, problem) in enumerate(merged_list, start=1):
        print(f"{idx}. {problem} (Category: {category})")


# Test the function with your arrays
merge_and_shuffle_with_categories(problems)
