"""
A simple Python script to calculate the nth Fibonacci number.
"""

def fibonacci(n):
    """
    Calculate the nth Fibonacci number using an iterative approach.
    
    Args:
        n (int): The position in the Fibonacci sequence.
        
    Returns:
        int: The nth Fibonacci number.
    """
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    
    previous, current = 0, 1
    for _ in range(2, n + 1):
        previous, current = current, previous + current
    return current


if __name__ == "__main__":
    # Test the function with a sample input
    N = 10  # Change this value to test with different inputs
    print(f"The {N}th Fibonacci number is: {fibonacci(N)}")
