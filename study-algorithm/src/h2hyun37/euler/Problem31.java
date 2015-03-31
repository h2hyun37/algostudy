package h2hyun37.euler;



/*
 * 영국의 화폐 단위는 파운드(£)와 펜스(p)이고, 동전의 종류는 아래와 같습니다.
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), £2 (200p)
 * 이 동전들을 가지고 2파운드를 만드는 방법은 다양할 것입니다. 예를 하나 들면 이렇습니다.
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 2파운드를 만드는 서로 다른 방법은 모두 몇가지나 있습니까?
 *
 */

public class Problem31 extends AbstractProblem {

	boolean printInfo = false; // true 로 변경시 중간중간 값을 출력한다


	int penny = 200; // 2파운드 = 200펜스.
	int[] coinlist = { 200, 100, 50, 20, 10, 5, 2, 1 }; // 200 ~ 1펜스까지.
	int[] cache = new int[coinlist[0] + 1];


	/*
	 * 캐시 내용 확인을 위한 메소드
	 */
	public String cacheToString(int[] cache) {

		StringBuilder sb = new StringBuilder();

		for (int idx = 0; idx < coinlist.length; idx++) {
			sb.append("{" + coinlist[idx] + ":" + cache[coinlist[idx]] + "} ");
		}

		return sb.toString();
	}


	/*
	 * 탭 출력을 위한 메소드
	 */
	public String getTab(int tabCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tabCount; i++) {
			sb.append("\t");
		}

		return sb.toString();
	}


	/*
	 * 큰 동전부터 갯수를 세어나가고 (갯수는 최대한 가능한 수부터~0까지.)
	 * 구하려는 값의 나머지가 생기면, 나머지와 그 다음 동전을 파라미터로 하여 재귀호출을 한다.
	 *
	 * 200 펜스를 구한다면
	 *
	 * 1) 200펜스 - 동전 1개, 나머지 0. 끝.
	 *
	 * 2) 100펜스 - 동전 2개, 나머지 0. 끝.
	 *
	 * 3) 100펜스 - 동전 1개, 나머지 100 -> 이 때에 재귀호출.
	 * ...
	 *
	 * 1펜스 - 동전 200개, 나머지 0. 끝.
	 *
	 *
	 * 이런 순서로 호출이 된다.
	 */
	public int getCoinCase(int penny, int coinIdx, int[] cache, int tabCount) {

		int caseCnt = 0;

		/*
		 * STEP 1 : 동전 확인, 해당 동전으로 최대한 가질 수 있는 동전 갯수 확인
		 */
		int coin = coinlist[coinIdx];
		int maxCoinCnt = penny / coin;


		/*
		 * STEP 2-1 : 동전이 1이라면 max Coin Count로 cache에 저장하고 리턴.
		 */
		if (coin == 1) {
			cache[coin] = maxCoinCnt;

			if (printInfo) {
				System.out.println(getTab(tabCount) + "[finish] : "
						+ cacheToString(cache));
			}

			caseCnt++;

		} else {

			/*
			 * STEP 2-2 : 동전이 1이 아니면, maxCoinCount -> 0개까지 루프를 돌면서 재귀호출.
			 */
			for (int coinCnt = maxCoinCnt; coinCnt >= 0; coinCnt--) {

				// 캐시에 해당 동전 갯수를 저장
				cache[coin] = coinCnt;

				// 남은 돈을 구한다
				int remainPenny = penny - coin * coinCnt;


				if (remainPenny > 0) {

					/*
					 * 다음 동전과 다음 동전 갯수를 미리 저장.
					 * 재귀호출 뒤에 복구가 필요하다 : cache를 int[]로 쓰기 때문.
					 */
					int nextCoin = coinlist[coinIdx + 1];
					int nextCoinCnt = cache[nextCoin];

					/*
					 * 재귀호출
					 */
					caseCnt += getCoinCase(remainPenny, coinIdx + 1, cache, tabCount + 1);

					/*
					 * 재귀호출 이전의 상태로 cache 복구.
					 */
					cache[nextCoin] = nextCoinCnt;


				} else {
					if (printInfo) {
						System.out.println(getTab(tabCount) + "[finish] : "
								+ cacheToString(cache));
					}
					caseCnt++;
				}

			}
		}


		return caseCnt;

	}

	@Override
	public void solveProblem() {

		/*
		 * recursive
		 */
		int coinIdx = 0; // 맨 처음에 계산할 동전.
		int caseCnt = getCoinCase(penny, coinIdx, cache, 0);

		System.out.println("case of making " + penny + " pence : " + caseCnt);

		/*
		 * TODO : Dynamic Programming
		 */

	}

	public static void main(String[] args) {

		Problem31 problem = new Problem31();
		problem.solveProblemWithTimeMeasurement();

	}


}
