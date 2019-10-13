package card;

/**
 * トランプのカードを表すクラス。
 *
 * @author cilmesource
 *
 */
public class Card {

  /** ジョーカーを表す定数 */
  public static final int JOKER = 0;

  /** スペードを表す定数 */
  public static final int SUIT_SPADE = 1;

  /** ダイヤを表す定数 */
  public static final int SUIT_DIAMOND = 2;

  /** クラブを表す定数 */
  public static final int SUIT_CLUB = 3;

  /** ハートを表す定数 */
  public static final int SUIT_HEART = 4;

  /** カードの示す絵柄(スート) */
  private int suit;

  /* カードの示す数字 */
  private int cardNumber;

  /**
   * コンストラクタ
   *
   * @param suit 絵柄(スート)
   * @param cardNumber数字(0の場合はジョーカーとして扱う。)
   */
  public Card(int suit, int cardNumber) {
    this.suit = suit;
    this.cardNumber = cardNumber;
  }

  /**
   * カードの数字を見る。
   *
   * @return cardNumber 数字
   */
  public int getCardNumber() {
    return cardNumber;
  }

  /**
   * カードを文字列で表現する。
   *
   * @return カードの文字表現
   */
  @Override
  public String toString() {
    StringBuffer string = new StringBuffer();

    if (cardNumber > 0) {

      // スートの表示
      switch (suit) {
      case SUIT_SPADE:
        string.append("S");
        break;
      case SUIT_DIAMOND:
        string.append("D");
        break;
      case SUIT_CLUB:
        string.append("C");
        break;
      case SUIT_HEART:
        string.append("H");
        break;
      default:
        break;
      }

      // 数字の表示
      switch (cardNumber) {
      case 1:
        string.append("A");
        break;
      case 11:
        string.append("J");
        break;
      case 12:
        string.append("Q");
        break;
      case 13:
        string.append("K");
        break;
      default:
        string.append(cardNumber);
        break;
      }

    } else {
      // ジョーカーを表す
      string.append("JOKER");
    }

    return string.toString();
  }
}
