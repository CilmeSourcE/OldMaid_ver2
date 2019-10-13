package hand;

import java.util.ArrayList;
import java.util.List;

import card.Card;

/**
 * ババ抜きの手札を表すクラス。
 *
 * @author cilmesource
 */
public class Hand {

  /** 手札のカードを表すためのリスト */
  public List<Card> cardList = new ArrayList<>();

  /**
   * カードを手札に加える。
   *
   * @param card 加えるカード
   */
  public void addCard(Card card) {
    cardList.add(card);
  }

  /**
   * カードを引く。
   *
   * @return 引いたカード
   */
  public Card pickCard() {
    Card pickedCard = (Card) cardList.remove(0);

    return pickedCard;
  }

  /**
   * シャッフルをする。
   *
   */
  public void shuffle() {

    // 手札の枚数を取得
    int number = cardList.size();

    // カードを抜き出す位置
    int pos = 0;

    for (int i = 0; i < number * 2; i++) {
      // ランダムな位置からカードを1枚引く
      pos = (int) (Math.random() * number);
      Card pickedCard = (Card) cardList.remove(pos);

      // 引いたカードをリストの最後に加える
      cardList.add(pickedCard);
    }
  }

  /**
   * カードの枚数を数える。
   *
   * @return 枚数
   */
  public int getNumberOfCards() {
    return cardList.size();
  }

  /**
   * 同じ数字の組み合わせのカードを探す。
   * 無い場合、nullを返す。
   * @return 同じ数字のカード
   */
  public Card[] findSameNumberCard() {
    int numberOfCards = cardList.size();
    Card[] sameCards = null;

    // 手札にカードが1枚もない場合は何もしない
    if (numberOfCards > 0) {
      // 最後に追加されたカードを取得する
      int lastIndex = numberOfCards - 1;
      Card lastAddedCard = (Card) cardList.get(lastIndex);

      // 最後に追加されたカードの数字を取得する
      int lastAddedCardNum = lastAddedCard.getCardNumber();

      for (int i = 0; i < lastIndex; i++) {
        Card card = cardList.get(i);
        if (card.getCardNumber() == lastAddedCardNum) {
          // 最後に追加されたカードと同じカードが見つかった場合、
          // 見つかった組み合わせをsameCardsに格納し、ループを抜ける
          sameCards = new Card[2];
          sameCards[0] = (Card) cardList.remove(lastIndex);
          sameCards[1] = (Card) cardList.remove(i);
          break;
        }
        // 同じ数の組み合わせが見つからなかった場合、
        // sameCardsはnullのままとなる
      }
    }

    return sameCards;
  }

  /**
   * 手札にあるカードを文字列で表現する。
   *
   * @return 手札にあるカードの文字列表現
   */
  @Override
  public String toString() {
    StringBuffer string = new StringBuffer();

    int size = cardList.size();
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        Card card = cardList.get(i);
        string.append(card);
        string.append(" ");
      }
    }

    return string.toString();
  }
}
