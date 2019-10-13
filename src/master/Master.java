
package master;

import java.util.ArrayList;
import java.util.List;

import card.Card;
import hand.Hand;
import player.Player;

/**
 * 進行役を表すクラス。
 *
 * @author cilmesource
 */
public class Master {

  /** プレイヤーのリスト */
  private List<Player> players = new ArrayList<>();

  /*
   * ゲームの準備をする。
   * *
   * @param hand トランプを進行役の手札として渡す
   */
  public void prepareGame(Hand cards) {
    System.out.println("【カードを配ります。】\n");

    // トランプをシャッフルする
    cards.shuffle();

    // トランプの枚数を確認する
    int numberOfCards = cards.getNumberOfCards();

    // プレイヤーの人数を確認する
    int numberOfPlayers = players.size();

    for (int i = 0; i < numberOfCards; i++) {
      // カードを一枚引く
      Card card = cards.pickCard();

      // 各プレイヤーに順番にカードを配る
      Player player = (Player) players.get(i % numberOfPlayers);
      player.receiveCard(card);
    }
  }

  /**
   *ゲームを開始する。
   *
   */
  public void startGame() {
    System.out.println("\n【ゲームを開始します。】");

    // プレイヤーの人数を取得する
    for (int cnt = 0; players.size() > 1; cnt++) {
      int playerIndex = cnt % players.size();
      int nextPlayerIndex = (cnt + 1) % players.size();

      // 指名するプレイヤーの取得
      Player player = (Player) players.get(playerIndex);

      // 次のプレイヤーの取得
      Player nextPlayer = (Player) players.get(nextPlayerIndex);

      // プレイヤーを指名する
      System.out.println("\n" + player + "さんの番です。");
      player.play(nextPlayer);
    }

    // プレイヤーが上がり、残り1名になるとロープから抜ける
    System.out.println("\n【ばば抜きを終了しました。】");
  }

  /**
   * 上がりを宣言する。
   *
   * @param player 上がったプレイヤー
   */
  public void declareWin(Player winner) {
    // 上がったプレイヤー
    System.out.println(winner + "さんが上がりました！");

    // 上がったプレイヤーをリストから外す
    players.remove(players.indexOf(winner));

    // 残りプレイヤーが1人になったときは敗者を表示する
    if (players.size() == 1) {
      Player loser = players.get(0);
      System.out.println("\n" + loser + "さんの負けです。");
    }
  }

  /**
   * ゲームに参加するプレイヤーを登録する。
   *
   * @param player
   */
  public void registerPlayer(Player player) {
    // リストに参加者を追加する
    players.add(player);
  }

}
