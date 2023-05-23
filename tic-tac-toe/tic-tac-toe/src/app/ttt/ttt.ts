type Player = 'X' | 'O';
type Board = (Player | null)[][];
type Move = { row: number; col: number; };

class TicTacToe {
    private currentPlayer: Player;
    public board: Board;

    constructor() {
        this.currentPlayer = 'X';
        this.board = Array(3).fill(null).map(() => Array(3).fill(null));
    }

    getCurrentBoard(): Board {
        return this.board;
    }

    playMoveByPlayer(move: Move): void {
        if (this.board[move.row][move.col] === null) {
            this.board[move.row][move.col] = this.currentPlayer;
            this.swapPlayer();
        }
    }

    swapPlayer(): void {
        this.currentPlayer = this.currentPlayer === 'X' ? 'O' : 'X';
    }

    playMoveByAI(): void {
        let bestScore = -Infinity;
        let move: Move = { row: -1, col: -1 };

        for (let i = 0; i < 3; i++) {
            for (let j = 0; j < 3; j++) {
                if (this.board[i][j] === null) {
                    this.board[i][j] = this.currentPlayer;
                    let score = this.minimax(this.board, false);
                    this.board[i][j] = null;
                    if (score > bestScore) {
                        bestScore = score;
                        move = { row: i, col: j };
                    }
                }
            }
        }

        if (move.row !== -1 && move.col !== -1) {
            this.board[move.row][move.col] = this.currentPlayer;
            this.swapPlayer();
        }
    }

    private minimax(board: Board, isMaximizing: boolean): number {
        let result = this.checkWinner();
        if (result !== null) {
            return this.score(result);
        }

        if (isMaximizing) {
            let bestScore = -Infinity;
            for (let i = 0; i < 3; i++) {
                for (let j = 0; j < 3; j++) {
                    if (board[i][j] === null) {
                        board[i][j] = this.currentPlayer;
                        let score = this.minimax(board, false);
                        board[i][j] = null;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            let bestScore = Infinity;
            for (let i = 0; i < 3; i++) {
                for (let j = 0; j < 3; j++) {
                    if (board[i][j] === null) {
                        board[i][j] = this.currentPlayer === 'X' ? 'O' : 'X';
                        let score = this.minimax(board, true);
                        board[i][j] = null;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private checkWinner(): Player | null {
        // Check rows, columns and diagonals
        for (let i = 0; i < 3; i++) {
            if (this.board[i][0] !== null && this.board[i][0] === this.board[i][1] && this.board[i][0] === this.board[i][2]) {
                return this.board[i][0];
            }
            if (this.board[0][i] !== null && this.board[0][i] === this.board[1][i] && this.board[0][i] === this.board[2][i]) {
                return this.board[0][i];
            }
        }
        if (this.board[0][0] !== null && this.board[0][0] === this.board[1][1] && this.board[0][0] === this.board[2][2]) {
            return this.board[0][0];
        }
        if (this.board[0][2] !== null && this.board[0][2] === this.board[1][1] && this.board[0][2] === this.board[2][0]) {
            return this.board[0][2];
        }

        // If there are no more null values, it's a tie
        if (!this.board.flat().includes(null)) {
            return 'X';
        }

        return null;
    }

    private score(winner: Player): number {
        if (winner === this.currentPlayer) {
            return 1;
        } else if (winner === (this.currentPlayer === 'X' ? 'O' : 'X')) {
            return -1;
        } else {
            return 0;
        }
    }
}
