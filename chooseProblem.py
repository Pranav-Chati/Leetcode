import random

problems = {
    "Pattern Sliding Window": [
        "1. Introduction",
        "2. Maximum Sum Subarray of Size K",
        "3. Smallest Subarray with given sum",
        "4. Longest Substring with K Distinct Characters",
        "5. Fruits into basket",
        "6. no-repeat substring",
    ],
    "Two Pointers": [
        "1. pair with target sum",
        "2. Remove Duplicates",
        "3. Squaring a sorted array",
        "4. Triplet sum to zero",
        "5. triplet sum close to target",
    ],
    "Fast Slow Pointers": [
        "1. LinkedList Cycle",
        "2. Start of LL Cycle",
        "3. Happy Number",
        "4. Middle of LL",
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
