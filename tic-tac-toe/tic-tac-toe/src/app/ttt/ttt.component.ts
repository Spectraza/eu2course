import {Component} from '@angular/core';
import {Board, TicTacToe} from './ttt';

@Component({
  selector: 'app-ttt',
  templateUrl: './ttt.component.html',
  styleUrls: ['./ttt.component.scss']
})
export class TTTComponent {
  ttt = new TicTacToe();
  icons = {
    X: 'clear',
    O: 'panorama_fish_eye',
    '': 'minimize',
  };

  playMove(i: number, j: number) {
    this.ttt.playMove({row: i, col: j});
  }
}
