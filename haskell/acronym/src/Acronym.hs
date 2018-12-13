module Acronym (abbreviate) where

import Data.Char

abbreviate :: String -> String
abbreviate xs =
  onlyAlpha $ concat $ capitalise $ split xs [' ', '-']
  
split :: String -> [Char] -> [String]
split [] _ = [""]
split (c : cs) delimiters
  | (c `elem` delimiters) = "" : rest
  | otherwise = (c : head rest) : tail rest
  where
    rest = split cs delimiters

capitalise :: [String] -> [String]
capitalise xs = map capitaliseWord xs
  where
    capitaliseWord :: String -> String
    capitaliseWord (c : cs)
      | all isUpper cs = [toUpper c]
      | otherwise = [toUpper c] ++ cs
    capitaliseWord cs = cs

onlyAlpha :: String -> String
onlyAlpha xs = filter (isAlpha) (filter (not . isLower) xs)