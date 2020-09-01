# For a given sentence, return the average word length. 
# Note: Remember to remove punctuation first.

import re

def average_word_length(sentence: str) -> float:
	words = re.split(',| |\?|\!|;|-', sentence)
	while '' in words:
		words.remove('')
	return float(sum(len(w) for w in words) / len(words))
		
print(average_word_length('This, this is so amazing, isnt it? - said Poirot'))
print(average_word_length('Me? What have I done?'))