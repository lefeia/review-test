def insert_string(s):
    """
    Reverses the input string s.

    Args:
        s (str): The string to be reversed.
        
    Returns:
        str: The reversed string.
    """
    return s[::-1]

if __name__ == "__main__":
    test_string = "hello"
    print(f"Original: {test_string}")
    print(f"Reversed: {reverse_string(test_string)}")