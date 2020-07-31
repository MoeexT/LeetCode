#! py -3


def quick_sort(array: list, low: int, high: int):
    if low < high:
        mid = _quick_pass(array, low, high)
        quick_sort(array, low, mid - 1)
        quick_sort(array, mid + 1, high)


def _quick_pass(array: list, low: int, high: int) -> int:
    guard = array[low]
    i = low + 1
    j = high
    while True:
        while array[i] < guard and i < high:
            i += 1
        while array[j] > guard:
            j -= 1
        if i >= j:
            break
        array[i], array[j] = array[j], array[i]

    array[low] = array[j]
    array[j] = guard

    return j


if __name__ == "__main__":
    # li = [62, 34, 343, 6, 72, 45, 42, 25, 82, 46, 27, 42, 72]
    li = [0,0,0,2,0,5]
    quick_sort(li, 0, len(li)-1)
    # _quick_pass(li, 0, len(li)-1)
    print(li)
