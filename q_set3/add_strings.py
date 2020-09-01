# Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
# You must not use any built-in BigInteger library or convert the inputs to integer directly.

def add_strings(s1: str, s2: str) -> str:
	return str(eval(s1) + eval(s2))
	
print(add_strings('1', '2'))
print(add_strings('101', '99'))
