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
		circle(); // 进行递归
		
		for (int[] array : cases) {
			String output = "100=";
			for (int item : array) {
				output += item + "*";
			}
			output = output.substring(0, output.length() - 1);
			System.out.println(output);
		}
	}
	
	public static void circle() {
		for (int i = 0; i < options.size(); i++) {
			stack.push(options.get(i));
			if (stack.size() == 6) {
				int[] figures = new int[stack.size()];
				int sum = 0;
				for (int j = 0; j < figures.length; j++) {
					figures[j] = stack.get(j);
					sum += stack.get(j);
				}
				if (sum == 100) {
					addToCases(figures);
				}
			}
			if (stack.size() < 6) {
				circle();
			}
			stack.pop();
		}
	}
	
	public static void addToCases(int[] figures) {
		Arrays.sort(figures);
		for (int i = 0; i < cases.size(); i++) {
			if (Arrays.equals(figures, cases.get(i))) { // 判断两个数组是否大小相等，每位数也相等
				return;
			}
		}
		cases.add(figures);
	}
}
