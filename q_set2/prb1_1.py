k = 3
numbers = [6, 5, 2, 6, 6, 2, 1, 7, 3, 3, 3]
numbers.sort()
# numbers = numbers[::-1]

dct = {}


def find_sublist(nbs: list, index: int):  # first from the sublist
    next = index + 1
    if next > len(nbs) - 1:
        return len(nbs) - 1
    while nbs[next] == nbs[index]:
        if next == len(nbs) - 1:
            return len(nbs) - 1
        next += 1
    next -= 1
    return next


# print(numbers)
index = 0
new_index = 0
while new_index < len(numbers) - 1:
    new_index = find_sublist(numbers, index)
    n = numbers[index:new_index + 1]
    # print(n)
    index = new_index + 1
    dct[n[0]] = len(n)

dct = sorted(dct.items(), key=lambda item: item[1])
for key, value in list(reversed(list(dct)))[0:k]:
    print(key)
