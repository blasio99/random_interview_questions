string = '("John", ("Jasmine", ("Jay"), ("Unavailable")), ("Unavailable", ("Jack", ("Jeremy"))), ("Johanna"))'


def find_next_closing(st: str, index: int):
    next = index + 1
    inner = 0
    while next < len(st):
        if st[next] == "(":
            inner += 1
        if st[next] == ")" and inner != 0:
            inner -= 1
        elif st[next] == ")" and inner == 0:
            return next
        next += 1


def find_next_opening(st: str, index: int):
    next = index + 1
    while st[next] != "(":
        if next == len(st) - 1:
            return -1
        next += 1
    return next


o = 0
c = 0
while o != -1:
    c = find_next_closing(string, o)
    if string[o + 1:o + 14] == '"Unavailable"':
        if string[o:c + 1] == string:
            string = ""
            break
        string = string[0:o - 2] + string[c + 1:len(string)]
    o = find_next_opening(string, o)

print(string)
