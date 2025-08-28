# TicTacToe
This project provides a simple command-line Tic Tac Toe game that serves as a playground for experimenting with adversarial search engines. It includes multiple AI opponents so you can explore strategies ranging from random move selection to perfect play.

## Features
- Human vs. AI matches from the terminal.
- `CPUEasy` selects random legal moves for a quick baseline opponent.
- `CPUPerfect` implements a minimax search to play optimally.
- Modular grid and control classes make it easy to plug in new heuristics or search algorithms.

## Getting Started
1. Compile the sources:
   ```bash
   javac src/*.java
   ```
2. Run the game:
   ```bash
   java -cp src App
   ```
   You will play as `X` by entering positions 1–9. The AI plays as `O`.

## Exploring Adversarial Search
Use this repository as a lightweight environment to test ideas about adversarial search, evaluation functions, and game-tree exploration. Create new CPU classes or tweak the existing ones to observe how different algorithms behave in the Tic Tac Toe domain.

## Documentation
Additional assets, such as example results, are stored in the `doc/` directory.

