package main;

import card.Card;
import hand.Hand;
import master.Master;
import player.Player;
import table.Table;

/**
 * ババ抜きプログラムを実行するクラス。
 *
 * @author cilmesource
 *
 */
public class OldMaidMain {

  /**
   * メインメソッド。
   *
   * @param args
   */
  public static void main(String[] args) {
    // 進行役の生成
    Master master = new Master();

    // テーブルの生成
    Table table = new Table();

    // プレイヤーの生成
    Player sato = new Player("佐藤", master, table);
    Player tanaka = new Player("田中", master, table);
    Player morita = new Player("森田", master, table);

    // 進行役にプレイヤーを登録する
    master.registerPlayer(sato);
    master.registerPlayer(tanaka);
    master.registerPlayer(morita);

    // トランプカードの生成
    Hand trump = createTrump();

    // ゲームの準備
    master.prepareGame(trump);

    // ゲーム開始！
    master.startGame();

  }

  /**
   * 53枚のトランプを生成する。
   *
   * @return トランプを格納した手札オブジェクト
   */
  private static Hand createTrump() {
    Hand trump = new Hand();

    // 計53枚のカードを生成
    for (int number = 1; number <= 13; number++) {
      trump.addCard(new Card(Card.SUIT_SPADE, number));
      trump.addCard(new Card(Card.SUIT_DIAMOND, number));
      trump.addCard(new Card(Card.SUIT_CLUB, number));
      trump.addCard(new Card(Card.SUIT_HEART, number));
    }

    // ジョーカーの生成
    trump.addCard(new Card(0, Card.JOKER));

    return trump;
  }
}
