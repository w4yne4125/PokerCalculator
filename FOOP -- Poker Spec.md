# FOOP -- Poker Calculator

> Side project for FOOP

## Spec

### Requirement

- A calculator for a player to estimate the following probabilities given the player's hand.
  - The prob. of hitting any kinds of set
    - Both pre-flop, post-flop, turn & river
  - The winning prob. facing random / specific hands
  - List the opponent hand that we have advantage against with.
- Hand strength estimator
  - Estimate the strength of given hand
  - List the hands above a given percentage
- Must have players' position considered
- Based on the opening position, determined that one should 3-bet or not.
  - List the suggested strength and actual strength
- NOT a poker SIMULATOR, so we don't need to actually have a real dealer.

### Good to have

- UI
- bet sizing



## Syllabus

### System Design

Some rough Classes, add more during the development.

![Screen Shot 2021-03-15 at 1.28.56 AM](/Users/wayne/Library/Application Support/typora-user-images/Screen Shot 2021-03-15 at 1.28.56 AM.png)



### User Procedure

1. Open Application, enter initial position (default BB).
2. (Start of Loop)
3. Enter user's hand
4. (Maybe) enter others' opening
5. Show the probabilities.
6. Press Next round, update the round information
7. Back to (2.)

### Phase1

- Enter the hands of the opponent and yours (1v1), then output the win probability // Analyzer
- Based on the position and hand, decide to open or not (No 3-bet function yet) // Add position

### Phase2

- The prob. of hitting any kinds of set both at post-flop, turn & river
- The winning prob. facing **random** hands / Or the percentage-based strength

### Phase3

- Implement of UI
  - Next hand Botton, 
  - Show the probabilities on time
- 3-bet decider





## Issues and solution

- Comparison between enums