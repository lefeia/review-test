class StringUtils:
    def __init__(self):
        pass

    # 改进：加上类型检查
    def reverse_string(self, s: str) -> str:
        if not isinstance(s, str):
            raise TypeError("Input must be a string")
        return s[::-1]

    # 改进：按规范命名并做空字符串检查
    def capitalize_string(self, string: str) -> str:
        if not isinstance(string, str):
            raise TypeError("Input must be a string")
        if not string:
            return ""  # 空字符串处理
        return string.upper()

    # 改进：加上类型检查并处理数字类型
    def is_palindrome(self, s: str) -> bool:
        if not isinstance(s, str):
            s = str(s)  # 如果传入的是数字，自动转为字符串
        return s == s[::-1]

    # 改进：处理除零错误
    def divide(self, a: int, b: int) -> float:
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero")
        return a / b


# 测试代码
if __name__ == "__main__":
    utils = StringUtils()

    # 改进：数字转为字符串进行回文判断
    print("是否回文：", utils.is_palindrome(12321))  # 输出：True

    # 改进：除法处理除零错误
    try:
        print("除法结果：", utils.divide(10, 2))  # 输出：5.0
    except ZeroDivisionError as e:
        print("错误:", e)
