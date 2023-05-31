export type Player = 'X' | 'O';
export type Board = (Player | '')[][];
export type Move = { row: number; col: number };

export class TicTacToe {
  currentPlayer: Player = 'X';
  board: Board;
  memo: Map<string, number> = new Map();

  constructor() {
    this.board = [];
    this.resetBoard();
  }

  public resetBoard() {
    this.board = Array.from({ length: 3 }, () => new Array(3).fill(''));
    this.currentPlayer = 'X';
  }

  public playMove(move: Move) {
    if (this.board[move.row][move.col] == '') {
      this.board[move.row][move.col] = this.currentPlayer;
      this.swapPlayer();
    }
  }

  public swapPlayer() {
    this.currentPlayer = this.currentPlayer == 'X' ? 'O' : 'X';
  }

  public checkWinner(board: Board): Player | '' | null {
    // rows
    for (const row of board) {
      const player = row[0];

      if (player == '') {
        continue;
      }

      let isWin: boolean = true;
      for (const cell of row) {
        if (player != cell) {
          isWin = false;
          break;
        }
      }

      if (isWin) {
        return player;
      }
    }

    // columns
    for (let i = 0; i < 3; i++) {
      const player = board[0][i];
      if (player == '') {
        continue;
      }
      let isWin: boolean = true;
      for (let j = 0; j < 3; j++) {
        if (player != board[j][i]) {
          isWin = false;
          break;
        }
      }

      if (isWin) {
        return player;
      }
    }

    // diags
    const player = board[1][1];

    let isWin: boolean = true;
    if (player != '') {
      for (let i = 0; i < 3; i++) {
        if (player != board[i][i]) {
          isWin = false;
          break;
        }
      }
      if (isWin) {
        return player;
      }
      isWin = true;
      for (let i = 0; i < 3; i++) {
        if (player != board[2 - i][i]) {
          isWin = false;
          break;
        }
      }
      if (isWin) {
        return player;
      }
    }

    if (this.getAllMoves(board).length == 0) {
      return '';
    }

    return null;
  }

  public getAllMoves(board: Board): Move[] {


    let moves: Move[] = [];

    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        if (board[i][j] == '') {
          moves.push({ row: i, col: j });
        }
      }
    }

    return moves;
  }

  public aiMove() {
    let moves = this.getAllMoves(this.board);
    let grades = [];

    for (const move of moves) {
      grades.push(
        this.minimax(structuredClone(this.board), this.currentPlayer, move, this.memo)
      );
    }

    const max = Math.max(...grades);
    const indexes: number[] = [];

    grades.forEach((value, index) => {
      if (value === max) {
        indexes.push(index);
      }
    });

    const randomIndex = indexes[Math.floor(Math.random() * indexes.length)];

    this.playMove(moves[randomIndex]);
  }

  public minimax(board: Board, player: Player, move: Move, memo: Map<string, number> = new Map()): number {
    board[move.row][move.col] = player;

    const winner = this.checkWinner(board);

    if (winner != null) {
      if (winner == player) {
        return 100;
      }

      if (winner == '') {
        return 0;
      }

      if (winner != player) {
        return -100;
      }
    }

    // Convert the board to a string representation that can be used as a key in the memo map.
    const boardKey = JSON.stringify({ board, player });

    // If the board state has been calculated before, return the memoized value.
    if (memo.has(boardKey)) {
      return <number>memo.get(boardKey);
    }

    const moves = this.getAllMoves(board);
    let opponent: Player = player == 'X' ? 'O' : 'X';
    let grades: number[] = [];

    for (const move of moves) {
      grades.push(this.minimax(structuredClone(board), opponent, move, memo));
    }

    let max = Math.max(...grades);
    let result = max;

    for (const grade of grades) {
      if (grade == max) {
        result += max;
      }
    }

    result = -result;

    // Store the result in the memo map before returning it.
    memo.set(boardKey, result);

    return result;
  }


}
