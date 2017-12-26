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
		long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��
		circle(); // ���еݹ�
		long endTime = System.currentTimeMillis();    //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺" + (endTime - startTime) + " ms");    //�����������ʱ��
	}

	public static void circle() { // �ݹ�ѭ��
		for (int i = 0; i < options.size(); i++) { 
			stack.push(options.get(i));
			
			if (stackSum() == 100) { // ����Ϊ100����ջ��СΪ6��ʱ���������
				if (stack.size() == 6) {
					int[] figures = stackToArray();
					addToCases(figures);
				}
			} else if ((stackSum() > 100)) { // �Ż��㷨��ȥ�� else if �������ִ��ʱ�� 20+s
				// ���ʹ���100�󣬳�ջ���˳���ǰѭ��
				stack.pop();
				break;
			}
			if (stack.size() < 6) { // ��һ��ѭ��
				circle();
			}
			stack.pop();
		}
	}

	public static int stackSum() { // ջ��Ԫ�����
		int sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}
		return sum;
	}

	public static int[] stackToArray() { // ��ջ��Ԫ�ش浽����
		int[] figures = new int[stack.size()];
		for (int i = 0; i < figures.length; i++) {
			figures[i] = stack.get(i);
		}
		return figures;
	}

	public static void addToCases(int[] figures) { // ���������ж��ظ�
		Arrays.sort(figures);
		for (int i = 0; i < cases.size(); i++) {
			if (Arrays.equals(figures, cases.get(i))) { // �ж����������Ƿ��С��ȣ�ÿλ��Ҳ���
				return;
			}
		}	
		cases.add(figures);
		// ��������������������������������������������������������������������������������
		// ��������������������������������������������������������������������������������
		// ȥ���ظ�ֵ
		
		String output = "100=";
		for (int item : figures) {
			output += item + "+";
		}
		output = output.substring(0, output.length() - 1);
		System.out.println(output);
	}
}
