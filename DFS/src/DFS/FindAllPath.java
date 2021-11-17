package DFS;
import java.util.*;

// 노드 1에서 노드 4까지 가는 모든 경우를 출력하는 문제

class DFSAlgorithm {
	private int maps[][] = new int[6][6];
	private boolean visit[] = new boolean[6];
	Stack<Integer> stack = new Stack<>();

// 데이터를 집어넣는 함수
// 무방향 그래프이므로 대칭으로 삽입
	public void inputData(int i, int j) {
		maps[i][j] = 1;
		maps[j][i] = 1;
	}

// DFS 구현 부분
// v : 출발노드, goal : 도착노드
	public void DFS(int v, int goal) {
		visit[v] = true;
		stack.push(v);

		if(v == goal) {
			int count = stack.size();
			for(int i=0; i<count; i++) {
				System.out.print(stack.elementAt(i)+" ");
			}
			System.out.println();
			stack.pop();
			return;
		}

		for(int i=0; i<6; i++) {
			if(maps[v][i]==1 && !visit[i]) {
				DFS(i, goal);
				visit[i] = false;
			}
		}
		stack.pop();
	}
}

public class FindAllPath {
	public static void main(String[] args) {
		DFSAlgorithm d = new DFSAlgorithm();
		d.inputData(1,2);
		d.inputData(1,3);
		d.inputData(2,3);
		d.inputData(2,5);
		d.inputData(3,4);
		d.inputData(3,5);
		d.inputData(4,5);

		d.DFS(1,4);
	}
}