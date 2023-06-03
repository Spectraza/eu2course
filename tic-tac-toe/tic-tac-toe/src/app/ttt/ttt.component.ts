import { Component } from '@angular/core';
import { Board, TicTacToe } from './ttt';

@Component({
  selector: 'app-ttt',
  templateUrl: './ttt.component.html',
  styleUrls: ['./ttt.component.scss'],
})
export class TttComponent {
  ttt = new TicTacToe();
  icons = {
    X: 'clear',
    O: 'panorama_fish_eye',
    '': 'minimize',
  };
  xWins = 0;
  oWins = 0;
  draws = 0;

  reset() {
    let winner = this.ttt.checkWinner(this.ttt.board);
    if (winner != null) {
      if (winner == 'X') {
        this.xWins++;
      }

      if (winner == 'O') {
        this.oWins++;
      }

      if (winner == '') {
        this.draws++;
      }
    }
    this.ttt.resetBoard();
  }

  playMove(i: number, j: number) {
    this.ttt.playMove({ row: i, col: j });
  }

}
