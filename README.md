# Weasel Program

The weasel program is a simulation illustrating that the process that drives evolutionary systems (random variation combined with non-random cumulative selection) is different from pure chance.

# Rules

1) Start with a random string of 28 characters.
2) Make 100 copies of the string (reproduce).
3) For each character in each of the 100 copies, with a probability of 5%, replace (mutate) the character with a new random character.
4) Compare each new string with the target string "METHINKS IT IS LIKE A WEASEL", and give each a score (the number of letters in the string that are correct and in the correct position).
5) If any of the new strings has a perfect score (28), halt. Otherwise, take the highest scoring string, and go to step 2.

For these purposes, a "character" is any uppercase letter, or a space. 
Correct letters are not "locked". Each correct letter may become incorrect in subsequent generations. The terms of the program and the existence of the target phrase do however mean that such 'negative mutations' will quickly be 'corrected'.
(Wikipedia).

# Screenshot

<img width="368" alt="screen shot 2018-05-21 at 08 11 56" src="https://user-images.githubusercontent.com/39402035/40294749-c818c72e-5cce-11e8-9151-2716b484523f.png">
