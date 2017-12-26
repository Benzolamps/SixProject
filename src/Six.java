import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * 有6个小于100的正整数，每个数中都含有6，它们的和是100，求出这6个数
 *
 * @author Benzolamps
 *
 */
public class Six {

	public static Vector<Integer> options = new Vector<Integer>();
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Vector<int[]> cases = new Vector<int[]>();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) { // 找出所有带6的数字
			if (i / 10 == 6 || i % 10 == 6) {
				options.add(i);
			}
		}
		long startTime = System.currentTimeMillis();    //获取开始时间
		circle(); // 进行递归
		long endTime = System.currentTimeMillis();    //获取结束时间
		System.out.println("程序运行时间：" + (endTime - startTime) + " ms");    //输出程序运行时间
	}

	public static void circle() { // 递归循环
		for (int i = 0; i < options.size(); i++) { 
			stack.push(options.get(i));
			
			if (stackSum() == 100) { // 当和为100并且栈大小为6的时候符合条件
				if (stack.size() == 6) {
					int[] figures = stackToArray();
					addToCases(figures);
				}
			} else if ((stackSum() > 100)) { // 优化算法，去掉 else if 语句块程序执行时间 20+s
				// 当和大于100后，出栈，退出当前循环
				stack.pop();
				break;
			}
			if (stack.size() < 6) { // 下一轮循环
				circle();
			}
			stack.pop();
		}
	}

	public static int stackSum() { // 栈中元素求和
		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		return sum;
	}

	public static int[] stackToArray() { // 将栈中元素存到数组
		int[] figures = new int[stack.size()];
		for (int i = 0; i < figures.length; i++) {
			figures[i] = stack.get(i);
		}
		return figures;
	}

	public static void addToCases(int[] figures) { // 输出结果并判断重复
		Arrays.sort(figures);
		for (int i = 0; i < cases.size(); i++) {
			if (Arrays.equals(figures, cases.get(i))) { // 判断两个数组是否大小相等，每位数也相等
				return;
			}
		}	
		cases.add(figures);
		// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
		// 去掉重复值
		
		String output = "100=";
		for (int item : figures) {
			output += item + "+";
		}
		output = output.substring(0, output.length() - 1);
		System.out.println(output);
	}
}
