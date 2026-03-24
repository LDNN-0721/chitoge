import java.util.Scanner;

public class ATM {
    // 任务1:ATM模拟器
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double account = 1000; // 初始余额1000元

        while (true) {
            System.out.println("\n===== ATM自助银行 =====");
            System.out.println("1. 账户余额  2. 取款  3. 存款  0. 退出");
            System.out.print("请选择操作：");

            // 先校验输入是否为整数，避免非数字输入崩溃
            if (!sc.hasNextInt()) {
                System.out.println("输入错误，请输入数字！");
                sc.next(); // 清空错误输入
                continue;
            }

            int choice = sc.nextInt();

            if (choice == 1) {
                // 查看余额
                System.out.println("账户余额：" + account + " 元");
            } else if (choice == 2) {
                // 取款
                System.out.print("请输入取款金额：");
                if (!sc.hasNextDouble()) {
                    System.out.println("输入错误，请输入合法金额！");
                    sc.next();
                    continue;
                }
                double amount = sc.nextDouble();

                // 双重校验：金额>0 且 余额足够
                if (amount <= 0) {
                    System.out.println("错误：取款金额必须大于0！");
                } else if (amount > account) {
                    System.out.println("错误：资金不足，可用余额：" + account + " 元");
                } else {
                    account -= amount;
                    System.out.println("取款成功！当前余额：" + account + " 元");
                }
            } else if (choice == 3) {
                // 存款
                System.out.print("请输入存款金额：");
                if (!sc.hasNextDouble()) {
                    System.out.println("输入错误，请输入合法金额！");
                    sc.next();
                    continue;
                }
                double amount = sc.nextDouble();

                // 校验存款金额>0
                if (amount <= 0) {
                    System.out.println("错误：存款金额必须大于0！");
                } else {
                    account += amount;
                    System.out.println("存款成功！当前余额：" + account + " 元");
                }
            } else if (choice == 0) {
                // 退出
                System.out.println("感谢使用，已退出！");
                sc.close(); // 关闭Scanner，避免资源泄漏
                break;
            } else {
                // 无效选项
                System.out.println("输入错误，请重新输入！");
            }
        }
    }
}