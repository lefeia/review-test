from collections import Counter

def count_words_in_fil(file_path):
    """
    Counts the occurrences of each word in a text file.

    Args:
        file_path (str): Path to the text file.
        
    Returns:
        dict: A dictionary with words as keys and counts as values.
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            words = file.read().split()
            return dict(Counter(words))
    except FileNotFoundError:
        print(f"The file at {file_path} was not found.")
        return {}

if __name__ == "__main__":
    # Replace 'example.txt' with the path to your text file.
    file_path = 'example.txt'
    word_counts = count_words_in_file(file_path)
    for word, count in word_counts.items():
        print(f"'{word}': {count}")