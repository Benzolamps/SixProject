import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 * 
 * ��6��С��100����������ÿ�����ж�����6�����ǵĺ���100�������6����
 * 
 * @author Benzolamps
 *
 */
public class Six {
	
	public static Vector<Integer> options = new Vector<Integer>();
	public static Stack<Integer> stack = new Stack<Integer>();
	public static Vector<int[]> cases = new Vector<int[]>();
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) { // �ҳ����д�6������
			if (i / 10 == 6 || i % 10 == 6) {
				options.add(i);
			}
		}
		circle(); // ���еݹ�
		
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
			if (Arrays.equals(figures, cases.get(i))) { // �ж����������Ƿ��С��ȣ�ÿλ��Ҳ���
				return;
			}
		}
		cases.add(figures);
	}
}
