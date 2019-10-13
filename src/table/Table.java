package table;

import java.util.ArrayList;
import java.util.List;

import card.Card;

/**
 * テーブルを表すクラス。
 *
 * @author cilmesource
 */
public class Table {

  /** 捨てられたカードを保持しておくためのリスト */
  List<Card[]> discardedCardList = new ArrayList<>();

  /**
   * カードを捨てる。
   *
   * @param cards 捨てるカードs
   */
  public void discardedCard(Card[] cards) {
    for (int i = 0; i < cards.length; i++) {
      // 捨てられたカードを表示する
      System.out.print(cards[i] + " ");
    }

    System.out.println("を捨てました。");

    // 捨てられたカードはリストに追加して保持しておく
    discardedCardList.add(cards);
  }
}
