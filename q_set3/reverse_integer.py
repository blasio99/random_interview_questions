# Given an integer, return the integer with reversed digits.
# Note: The integer could be either positive or negative.

def reverse_integer(integer: int) -> int:
	string = str(integer)
	return int(string[::-1]) if string[0] != '-' else int('-' + string[:0:-1])


print(reverse_integer(12345))
print(reverse_integer(-199))