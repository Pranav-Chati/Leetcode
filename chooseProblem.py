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
        "2. Insert Interval"
    ],
    "Cyclic Sort": [
        "1. Cyclic Sort",
        "2. Find the missing number",
        "3. Find all missing numbers",
        "4. Find the duplicate number",
        "5. Problem Challenge 1 - Find the Corrupt Pair",
    ],
    "InPlaceReversalLinkedList": [
        "1. Reverse a LinkedList",
        "2. Reverse a Sub-list",
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
