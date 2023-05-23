import { Component } from '@angular/core';
import './ttt'

@Component({
  selector: 'app-ttt',
  templateUrl: './ttt.component.html',
  styleUrls: ['./ttt.component.scss']
})
export class TTTComponent {
  ttt = new TicTacToe();

  icons = {
    'X': 'clear',
    'O': 'panorama_fish_eye',
    null : 'menu'
  }
}
