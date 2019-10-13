package player;

import card.Card;
import hand.Hand;
import master.Master;
import table.Table;

/**
 * プレイヤーを表すクラス。
 *
 * @author cilmesource
 */
public class Player {

  /** 進行役 */
  private Master master;

  /** テーブル */
  private Table table;

  /** 自分の手札 */
  private Hand myHand = new Hand();

  /** 名前 */
  private String name;

  /**
   * コンストラクタ
   *
   * @param name 名前
   * @param master 進行役
   * @param table テーブル
   */
  public Player(String name, Master master, Table table) {
    this.name = name;
    this.master = master;
    this.table = table;
  }

  /**
   * 順番を決める。
   *
   * @param nextPlayer 次のプレイヤー
   */
  public void play(Player nextPlayer) {
    // 次のプレイヤーに手札を出してもらう
    Hand nextHand = nextPlayer.showHand();

    // 相手の手札からカードを1枚引く
    Card pickedCard = nextHand.pickCard();

    // 引いたカードを表示
    System.out.println(this + ":" + nextPlayer + "さんから、" + pickedCard + "を引きました。");

    // 引いたカードを自分の手札に加え、同じ数字のカードがあったら捨てる
    dealCard(pickedCard);

    // 手札がゼロになったかどうか調べる
    if (myHand.getNumberOfCards() == 0) {
      // 進行役に上がりを宣言する
      master.declareWin(this);
    } else {
      // 現在の手札を表示する
      System.out.println(this + ":残りの手札は、" + myHand + "です。");
    }
  }

  /**
   * 手札を見せる。
   *
   * @return 自分の手札
   */
  public Hand showHand() {
    // もしこの時点で手札が残り1枚なら上がれるので、上がりを宣言する
    if (myHand.getNumberOfCards() == 1) {
      master.declareWin(this);
    }

    // 手札を見せる前にシャッフルする
    myHand.shuffle();

    return myHand;
  }

  /**
   * カードを受け取る。
   *
   * @param card 受け取ったカード
   */
  public void receiveCard(Card card) {
    // 引いたカードを自分の手札に加え、同じ数字のカードがあれば捨てる
    dealCard(card);
  }

  /**
   * カードを自分の手札に加え、同じ数字のカードがあれば捨てる。
   *
   * @param card
   */
  public void dealCard(Card card) {
    // カードを自分の手札に加える
    myHand.addCard(card);

    // 今加えたカードと同じカードを探す
    Card[] sameCards = myHand.findSameNumberCard();

    // 同じカードの組み合わせが存在した場合
    if (sameCards != null) {
      // テーブルへカードを捨てる
      System.out.print(this + ":");
      table.discardedCard(sameCards);
    }
  }

  /**
   * プレイヤーの名前を返す。
   *
   */
  @Override
  public String toString() {
    return name;
  }
}