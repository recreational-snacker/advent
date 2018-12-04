package advent2018;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

public class Advent2018Day4Test {

    private String input = "[1518-08-21 00:39] wakes up\n" +
            "[1518-08-11 00:56] wakes up\n" +
            "[1518-10-10 23:52] Guard #2707 begins shift\n" +
            "[1518-10-14 00:55] wakes up\n" +
            "[1518-07-19 00:42] wakes up\n" +
            "[1518-06-16 00:41] falls asleep\n" +
            "[1518-03-24 00:57] wakes up\n" +
            "[1518-05-06 00:39] wakes up\n" +
            "[1518-08-27 00:00] Guard #3323 begins shift\n" +
            "[1518-03-22 23:50] Guard #2753 begins shift\n" +
            "[1518-11-04 00:51] wakes up\n" +
            "[1518-08-02 00:02] Guard #1223 begins shift\n" +
            "[1518-06-11 00:46] wakes up\n" +
            "[1518-05-29 00:51] falls asleep\n" +
            "[1518-05-23 00:19] falls asleep\n" +
            "[1518-08-12 23:56] Guard #1283 begins shift\n" +
            "[1518-03-21 00:55] wakes up\n" +
            "[1518-10-14 00:39] falls asleep\n" +
            "[1518-04-10 00:00] Guard #1733 begins shift\n" +
            "[1518-05-08 00:46] wakes up\n" +
            "[1518-08-14 00:19] wakes up\n" +
            "[1518-08-02 00:31] wakes up\n" +
            "[1518-09-23 00:02] falls asleep\n" +
            "[1518-08-16 00:18] falls asleep\n" +
            "[1518-09-23 00:31] wakes up\n" +
            "[1518-04-27 00:42] wakes up\n" +
            "[1518-03-02 00:17] falls asleep\n" +
            "[1518-05-18 00:37] falls asleep\n" +
            "[1518-05-27 00:52] wakes up\n" +
            "[1518-07-22 23:50] Guard #2903 begins shift\n" +
            "[1518-10-27 00:01] Guard #1213 begins shift\n" +
            "[1518-10-17 00:51] falls asleep\n" +
            "[1518-09-17 00:19] falls asleep\n" +
            "[1518-08-05 00:08] falls asleep\n" +
            "[1518-09-08 00:04] Guard #2903 begins shift\n" +
            "[1518-09-12 00:47] falls asleep\n" +
            "[1518-10-13 00:03] Guard #3023 begins shift\n" +
            "[1518-08-15 00:31] wakes up\n" +
            "[1518-03-22 00:37] wakes up\n" +
            "[1518-02-23 00:30] falls asleep\n" +
            "[1518-03-25 00:59] wakes up\n" +
            "[1518-09-22 23:53] Guard #859 begins shift\n" +
            "[1518-04-21 00:54] wakes up\n" +
            "[1518-09-03 23:56] Guard #1597 begins shift\n" +
            "[1518-06-12 00:00] Guard #1231 begins shift\n" +
            "[1518-03-06 00:56] wakes up\n" +
            "[1518-05-30 00:14] falls asleep\n" +
            "[1518-05-27 00:49] falls asleep\n" +
            "[1518-08-14 00:34] falls asleep\n" +
            "[1518-02-16 00:51] wakes up\n" +
            "[1518-05-31 23:46] Guard #3023 begins shift\n" +
            "[1518-09-29 00:38] wakes up\n" +
            "[1518-09-20 00:19] wakes up\n" +
            "[1518-10-11 00:26] wakes up\n" +
            "[1518-06-08 00:33] falls asleep\n" +
            "[1518-09-01 00:15] falls asleep\n" +
            "[1518-11-11 00:56] wakes up\n" +
            "[1518-04-30 00:51] wakes up\n" +
            "[1518-06-28 00:28] wakes up\n" +
            "[1518-03-17 00:00] Guard #3449 begins shift\n" +
            "[1518-07-30 00:20] falls asleep\n" +
            "[1518-04-21 00:32] falls asleep\n" +
            "[1518-10-15 00:54] wakes up\n" +
            "[1518-05-25 00:50] falls asleep\n" +
            "[1518-07-23 00:26] wakes up\n" +
            "[1518-10-11 00:53] wakes up\n" +
            "[1518-05-13 00:47] falls asleep\n" +
            "[1518-08-17 00:37] falls asleep\n" +
            "[1518-11-18 23:54] Guard #1213 begins shift\n" +
            "[1518-04-22 00:30] wakes up\n" +
            "[1518-07-23 23:59] Guard #1213 begins shift\n" +
            "[1518-09-08 00:53] wakes up\n" +
            "[1518-06-09 00:00] Guard #1597 begins shift\n" +
            "[1518-09-19 00:02] falls asleep\n" +
            "[1518-11-10 00:09] falls asleep\n" +
            "[1518-03-07 00:23] falls asleep\n" +
            "[1518-06-07 23:47] Guard #1223 begins shift\n" +
            "[1518-06-28 00:06] wakes up\n" +
            "[1518-11-10 00:54] wakes up\n" +
            "[1518-03-20 00:26] falls asleep\n" +
            "[1518-10-10 00:27] falls asleep\n" +
            "[1518-04-12 00:01] Guard #3023 begins shift\n" +
            "[1518-02-24 00:01] falls asleep\n" +
            "[1518-05-11 00:03] Guard #3323 begins shift\n" +
            "[1518-06-04 00:03] Guard #2971 begins shift\n" +
            "[1518-07-21 00:56] wakes up\n" +
            "[1518-04-18 00:51] wakes up\n" +
            "[1518-07-08 23:56] Guard #3323 begins shift\n" +
            "[1518-04-11 00:42] wakes up\n" +
            "[1518-03-29 00:11] wakes up\n" +
            "[1518-05-08 00:54] wakes up\n" +
            "[1518-10-09 00:57] wakes up\n" +
            "[1518-08-13 00:27] falls asleep\n" +
            "[1518-07-29 00:56] wakes up\n" +
            "[1518-05-06 00:43] falls asleep\n" +
            "[1518-05-17 00:03] Guard #859 begins shift\n" +
            "[1518-10-26 00:37] falls asleep\n" +
            "[1518-07-28 00:54] wakes up\n" +
            "[1518-04-20 00:05] falls asleep\n" +
            "[1518-07-30 00:21] wakes up\n" +
            "[1518-11-10 00:34] falls asleep\n" +
            "[1518-11-06 00:34] wakes up\n" +
            "[1518-08-19 00:48] wakes up\n" +
            "[1518-08-12 00:56] wakes up\n" +
            "[1518-02-16 00:44] falls asleep\n" +
            "[1518-08-28 00:28] falls asleep\n" +
            "[1518-10-25 00:56] falls asleep\n" +
            "[1518-04-25 00:22] falls asleep\n" +
            "[1518-03-27 00:01] Guard #2251 begins shift\n" +
            "[1518-07-11 00:33] falls asleep\n" +
            "[1518-02-12 23:58] Guard #3449 begins shift\n" +
            "[1518-02-25 00:45] wakes up\n" +
            "[1518-04-13 00:50] wakes up\n" +
            "[1518-03-16 00:55] wakes up\n" +
            "[1518-03-22 00:31] falls asleep\n" +
            "[1518-06-29 00:28] falls asleep\n" +
            "[1518-11-22 00:51] wakes up\n" +
            "[1518-11-23 00:22] falls asleep\n" +
            "[1518-07-29 23:57] Guard #2251 begins shift\n" +
            "[1518-05-14 00:03] Guard #2903 begins shift\n" +
            "[1518-10-09 00:52] falls asleep\n" +
            "[1518-09-20 00:39] falls asleep\n" +
            "[1518-10-16 00:49] wakes up\n" +
            "[1518-07-04 00:59] wakes up\n" +
            "[1518-02-17 00:38] falls asleep\n" +
            "[1518-04-03 00:04] Guard #859 begins shift\n" +
            "[1518-03-08 00:00] falls asleep\n" +
            "[1518-03-20 00:57] wakes up\n" +
            "[1518-10-07 23:48] Guard #1223 begins shift\n" +
            "[1518-04-08 23:59] Guard #1223 begins shift\n" +
            "[1518-07-01 00:00] Guard #3023 begins shift\n" +
            "[1518-09-17 00:22] wakes up\n" +
            "[1518-03-15 00:00] Guard #1283 begins shift\n" +
            "[1518-07-16 00:10] falls asleep\n" +
            "[1518-04-03 00:34] falls asleep\n" +
            "[1518-11-23 00:04] Guard #1637 begins shift\n" +
            "[1518-10-19 00:53] wakes up\n" +
            "[1518-06-25 23:57] Guard #2851 begins shift\n" +
            "[1518-03-23 00:52] wakes up\n" +
            "[1518-04-21 00:02] Guard #1439 begins shift\n" +
            "[1518-05-09 23:57] Guard #1999 begins shift\n" +
            "[1518-08-03 00:19] falls asleep\n" +
            "[1518-10-04 00:51] falls asleep\n" +
            "[1518-06-01 00:53] wakes up\n" +
            "[1518-06-01 00:47] falls asleep\n" +
            "[1518-08-18 00:28] falls asleep\n" +
            "[1518-11-18 00:55] falls asleep\n" +
            "[1518-05-12 00:08] falls asleep\n" +
            "[1518-06-18 00:51] wakes up\n" +
            "[1518-07-25 00:33] falls asleep\n" +
            "[1518-08-03 00:37] wakes up\n" +
            "[1518-10-02 00:24] falls asleep\n" +
            "[1518-09-10 00:26] falls asleep\n" +
            "[1518-09-29 23:50] Guard #2851 begins shift\n" +
            "[1518-03-15 00:16] wakes up\n" +
            "[1518-07-26 00:30] falls asleep\n" +
            "[1518-03-12 00:03] falls asleep\n" +
            "[1518-07-28 00:01] Guard #2971 begins shift\n" +
            "[1518-02-25 00:00] falls asleep\n" +
            "[1518-11-01 00:21] falls asleep\n" +
            "[1518-04-02 00:56] falls asleep\n" +
            "[1518-04-25 00:36] wakes up\n" +
            "[1518-10-06 00:06] falls asleep\n" +
            "[1518-06-08 00:03] falls asleep\n" +
            "[1518-06-24 00:17] falls asleep\n" +
            "[1518-11-01 00:04] Guard #2707 begins shift\n" +
            "[1518-11-08 00:00] Guard #1223 begins shift\n" +
            "[1518-04-07 00:53] wakes up\n" +
            "[1518-08-10 00:50] falls asleep\n" +
            "[1518-10-25 00:44] falls asleep\n" +
            "[1518-08-05 00:02] Guard #887 begins shift\n" +
            "[1518-02-14 23:57] Guard #1597 begins shift\n" +
            "[1518-11-15 00:11] falls asleep\n" +
            "[1518-07-09 23:57] Guard #2851 begins shift\n" +
            "[1518-07-07 23:56] Guard #1597 begins shift\n" +
            "[1518-08-06 00:16] falls asleep\n" +
            "[1518-08-09 00:03] Guard #2707 begins shift\n" +
            "[1518-10-31 00:15] falls asleep\n" +
            "[1518-03-11 00:51] wakes up\n" +
            "[1518-04-14 00:06] falls asleep\n" +
            "[1518-08-25 23:58] Guard #887 begins shift\n" +
            "[1518-10-09 00:30] falls asleep\n" +
            "[1518-11-17 00:51] wakes up\n" +
            "[1518-06-23 00:58] wakes up\n" +
            "[1518-05-08 23:50] Guard #1283 begins shift\n" +
            "[1518-03-18 00:34] falls asleep\n" +
            "[1518-10-22 00:28] falls asleep\n" +
            "[1518-05-01 00:58] wakes up\n" +
            "[1518-05-21 00:37] wakes up\n" +
            "[1518-05-06 00:46] wakes up\n" +
            "[1518-04-07 00:32] wakes up\n" +
            "[1518-09-16 23:59] Guard #3323 begins shift\n" +
            "[1518-10-27 00:33] wakes up\n" +
            "[1518-04-11 00:37] falls asleep\n" +
            "[1518-05-05 00:50] falls asleep\n" +
            "[1518-06-06 00:45] wakes up\n" +
            "[1518-05-08 00:49] falls asleep\n" +
            "[1518-09-26 00:21] wakes up\n" +
            "[1518-09-18 23:50] Guard #1439 begins shift\n" +
            "[1518-02-08 00:06] falls asleep\n" +
            "[1518-06-20 00:36] wakes up\n" +
            "[1518-04-19 00:53] wakes up\n" +
            "[1518-05-15 00:56] wakes up\n" +
            "[1518-08-25 00:45] falls asleep\n" +
            "[1518-04-25 00:02] Guard #1439 begins shift\n" +
            "[1518-11-02 00:56] falls asleep\n" +
            "[1518-11-15 00:56] wakes up\n" +
            "[1518-07-17 00:58] wakes up\n" +
            "[1518-03-28 00:00] Guard #1597 begins shift\n" +
            "[1518-06-23 00:54] falls asleep\n" +
            "[1518-11-14 00:11] falls asleep\n" +
            "[1518-03-15 23:57] Guard #1597 begins shift\n" +
            "[1518-03-03 00:15] wakes up\n" +
            "[1518-08-31 00:06] falls asleep\n" +
            "[1518-08-10 00:03] Guard #3023 begins shift\n" +
            "[1518-04-29 00:04] falls asleep\n" +
            "[1518-04-08 00:01] Guard #1283 begins shift\n" +
            "[1518-03-28 00:51] wakes up\n" +
            "[1518-10-31 00:03] Guard #1213 begins shift\n" +
            "[1518-08-03 00:53] falls asleep\n" +
            "[1518-06-30 00:55] wakes up\n" +
            "[1518-07-24 00:21] wakes up\n" +
            "[1518-04-01 00:34] falls asleep\n" +
            "[1518-09-25 00:01] Guard #859 begins shift\n" +
            "[1518-03-24 00:00] Guard #859 begins shift\n" +
            "[1518-02-27 00:34] wakes up\n" +
            "[1518-03-15 00:51] wakes up\n" +
            "[1518-07-31 00:49] falls asleep\n" +
            "[1518-09-05 00:01] falls asleep\n" +
            "[1518-07-26 00:03] Guard #2971 begins shift\n" +
            "[1518-06-22 00:14] falls asleep\n" +
            "[1518-09-15 23:46] Guard #2971 begins shift\n" +
            "[1518-09-29 00:47] wakes up\n" +
            "[1518-05-05 00:00] Guard #1223 begins shift\n" +
            "[1518-11-18 00:58] wakes up\n" +
            "[1518-09-02 00:29] falls asleep\n" +
            "[1518-08-25 00:50] wakes up\n" +
            "[1518-08-08 00:56] wakes up\n" +
            "[1518-04-12 00:11] falls asleep\n" +
            "[1518-07-29 00:00] Guard #2903 begins shift\n" +
            "[1518-04-05 00:49] wakes up\n" +
            "[1518-11-20 00:57] wakes up\n" +
            "[1518-08-12 00:17] falls asleep\n" +
            "[1518-09-04 23:51] Guard #3121 begins shift\n" +
            "[1518-03-20 00:36] wakes up\n" +
            "[1518-03-05 00:42] wakes up\n" +
            "[1518-05-13 00:00] Guard #1439 begins shift\n" +
            "[1518-07-30 00:16] wakes up\n" +
            "[1518-06-07 00:49] wakes up\n" +
            "[1518-05-02 00:51] falls asleep\n" +
            "[1518-08-15 00:02] Guard #2753 begins shift\n" +
            "[1518-09-20 00:04] falls asleep\n" +
            "[1518-07-20 00:13] falls asleep\n" +
            "[1518-08-24 00:42] wakes up\n" +
            "[1518-11-20 00:37] falls asleep\n" +
            "[1518-09-06 00:53] falls asleep\n" +
            "[1518-10-18 00:37] falls asleep\n" +
            "[1518-08-05 00:56] wakes up\n" +
            "[1518-10-17 00:03] Guard #2753 begins shift\n" +
            "[1518-06-16 00:56] wakes up\n" +
            "[1518-09-28 00:50] wakes up\n" +
            "[1518-09-09 23:57] Guard #2707 begins shift\n" +
            "[1518-07-19 00:04] Guard #1231 begins shift\n" +
            "[1518-10-17 00:26] falls asleep\n" +
            "[1518-08-02 23:57] Guard #859 begins shift\n" +
            "[1518-09-01 23:56] Guard #3323 begins shift\n" +
            "[1518-08-15 00:17] falls asleep\n" +
            "[1518-10-09 00:49] wakes up\n" +
            "[1518-08-02 00:44] falls asleep\n" +
            "[1518-07-13 00:03] Guard #3121 begins shift\n" +
            "[1518-03-06 00:45] falls asleep\n" +
            "[1518-10-20 23:57] Guard #2753 begins shift\n" +
            "[1518-05-17 00:48] wakes up\n" +
            "[1518-10-01 00:12] falls asleep\n" +
            "[1518-08-30 00:33] falls asleep\n" +
            "[1518-02-18 00:13] falls asleep\n" +
            "[1518-05-13 00:44] wakes up\n" +
            "[1518-10-17 00:54] wakes up\n" +
            "[1518-08-20 00:01] Guard #911 begins shift\n" +
            "[1518-02-25 00:31] wakes up\n" +
            "[1518-09-04 00:28] falls asleep\n" +
            "[1518-10-16 00:01] Guard #2903 begins shift\n" +
            "[1518-02-12 00:47] wakes up\n" +
            "[1518-08-10 00:38] wakes up\n" +
            "[1518-09-14 00:45] wakes up\n" +
            "[1518-05-31 00:20] falls asleep\n" +
            "[1518-02-28 00:25] falls asleep\n" +
            "[1518-07-03 00:23] falls asleep\n" +
            "[1518-10-23 00:54] wakes up\n" +
            "[1518-02-16 00:56] falls asleep\n" +
            "[1518-07-11 00:57] wakes up\n" +
            "[1518-02-20 00:00] Guard #1999 begins shift\n" +
            "[1518-06-11 00:01] Guard #1439 begins shift\n" +
            "[1518-04-03 00:57] wakes up\n" +
            "[1518-05-28 00:03] Guard #1439 begins shift\n" +
            "[1518-03-19 00:16] falls asleep\n" +
            "[1518-09-10 00:53] wakes up\n" +
            "[1518-10-12 00:46] falls asleep\n" +
            "[1518-07-25 00:50] wakes up\n" +
            "[1518-06-23 23:47] Guard #1439 begins shift\n" +
            "[1518-07-27 00:05] falls asleep\n" +
            "[1518-05-30 00:26] wakes up\n" +
            "[1518-06-28 00:35] falls asleep\n" +
            "[1518-05-14 00:32] falls asleep\n" +
            "[1518-07-06 00:39] falls asleep\n" +
            "[1518-06-25 00:51] wakes up\n" +
            "[1518-09-06 00:03] Guard #3023 begins shift\n" +
            "[1518-11-08 00:43] falls asleep\n" +
            "[1518-09-25 00:40] wakes up\n" +
            "[1518-03-23 00:50] falls asleep\n" +
            "[1518-10-17 00:40] wakes up\n" +
            "[1518-02-09 00:16] falls asleep\n" +
            "[1518-09-10 00:56] falls asleep\n" +
            "[1518-04-10 00:54] wakes up\n" +
            "[1518-06-17 00:57] wakes up\n" +
            "[1518-04-19 00:43] falls asleep\n" +
            "[1518-11-16 00:06] falls asleep\n" +
            "[1518-09-11 00:19] wakes up\n" +
            "[1518-05-08 00:41] falls asleep\n" +
            "[1518-04-16 00:40] wakes up\n" +
            "[1518-11-17 00:41] wakes up\n" +
            "[1518-09-26 00:57] wakes up\n" +
            "[1518-04-30 00:01] Guard #2753 begins shift\n" +
            "[1518-04-11 00:50] falls asleep\n" +
            "[1518-04-09 00:58] wakes up\n" +
            "[1518-09-10 00:49] falls asleep\n" +
            "[1518-03-19 00:27] wakes up\n" +
            "[1518-03-27 00:38] wakes up\n" +
            "[1518-09-29 00:44] falls asleep\n" +
            "[1518-08-29 00:16] wakes up\n" +
            "[1518-09-24 00:47] wakes up\n" +
            "[1518-04-22 00:10] wakes up\n" +
            "[1518-09-08 00:29] falls asleep\n" +
            "[1518-05-21 00:09] falls asleep\n" +
            "[1518-03-28 00:41] falls asleep\n" +
            "[1518-07-08 00:33] wakes up\n" +
            "[1518-05-13 00:50] wakes up\n" +
            "[1518-11-06 00:01] Guard #911 begins shift\n" +
            "[1518-09-28 00:25] falls asleep\n" +
            "[1518-09-10 00:58] wakes up\n" +
            "[1518-09-03 00:03] falls asleep\n" +
            "[1518-04-28 23:50] Guard #2753 begins shift\n" +
            "[1518-08-10 23:57] Guard #1231 begins shift\n" +
            "[1518-05-31 00:51] wakes up\n" +
            "[1518-02-08 00:28] wakes up\n" +
            "[1518-08-01 00:00] Guard #3323 begins shift\n" +
            "[1518-02-14 00:43] falls asleep\n" +
            "[1518-06-08 00:28] wakes up\n" +
            "[1518-09-22 00:18] falls asleep\n" +
            "[1518-05-25 00:04] Guard #3121 begins shift\n" +
            "[1518-04-01 00:47] wakes up\n" +
            "[1518-03-29 00:16] falls asleep\n" +
            "[1518-07-14 00:01] falls asleep\n" +
            "[1518-09-12 00:14] falls asleep\n" +
            "[1518-07-10 00:51] wakes up\n" +
            "[1518-02-18 00:25] wakes up\n" +
            "[1518-05-04 00:00] Guard #2851 begins shift\n" +
            "[1518-08-30 00:59] wakes up\n" +
            "[1518-09-23 23:57] Guard #1223 begins shift\n" +
            "[1518-10-14 00:02] Guard #1231 begins shift\n" +
            "[1518-10-15 00:39] wakes up\n" +
            "[1518-09-16 00:59] wakes up\n" +
            "[1518-04-07 00:36] falls asleep\n" +
            "[1518-02-17 23:57] Guard #1213 begins shift\n" +
            "[1518-06-16 23:58] Guard #859 begins shift\n" +
            "[1518-04-27 00:20] wakes up\n" +
            "[1518-04-01 00:57] wakes up\n" +
            "[1518-09-09 00:43] wakes up\n" +
            "[1518-07-05 23:52] Guard #3023 begins shift\n" +
            "[1518-09-06 00:23] falls asleep\n" +
            "[1518-07-28 00:14] falls asleep\n" +
            "[1518-05-14 00:50] wakes up\n" +
            "[1518-06-30 00:22] falls asleep\n" +
            "[1518-03-04 00:58] wakes up\n" +
            "[1518-11-03 00:59] wakes up\n" +
            "[1518-05-09 00:03] falls asleep\n" +
            "[1518-06-24 00:04] wakes up\n" +
            "[1518-10-30 00:19] falls asleep\n" +
            "[1518-03-04 00:51] wakes up\n" +
            "[1518-10-30 00:23] wakes up\n" +
            "[1518-03-13 00:00] Guard #859 begins shift\n" +
            "[1518-03-30 00:56] wakes up\n" +
            "[1518-04-18 00:06] falls asleep\n" +
            "[1518-05-01 00:25] falls asleep\n" +
            "[1518-02-26 00:51] wakes up\n" +
            "[1518-03-18 00:48] wakes up\n" +
            "[1518-08-13 00:55] wakes up\n" +
            "[1518-05-21 23:57] Guard #2251 begins shift\n" +
            "[1518-11-21 00:25] falls asleep\n" +
            "[1518-04-12 00:38] falls asleep\n" +
            "[1518-02-19 00:46] wakes up\n" +
            "[1518-06-28 00:01] falls asleep\n" +
            "[1518-03-13 00:28] falls asleep\n" +
            "[1518-10-22 00:50] wakes up\n" +
            "[1518-09-17 00:38] falls asleep\n" +
            "[1518-10-13 00:58] wakes up\n" +
            "[1518-10-14 00:19] falls asleep\n" +
            "[1518-09-02 00:25] wakes up\n" +
            "[1518-09-05 00:28] wakes up\n" +
            "[1518-09-10 00:31] wakes up\n" +
            "[1518-03-09 00:04] Guard #233 begins shift\n" +
            "[1518-06-02 00:19] falls asleep\n" +
            "[1518-06-14 00:21] wakes up\n" +
            "[1518-07-02 23:59] Guard #2251 begins shift\n" +
            "[1518-09-13 00:09] falls asleep\n" +
            "[1518-07-31 00:58] wakes up\n" +
            "[1518-11-05 00:13] falls asleep\n" +
            "[1518-04-15 00:54] wakes up\n" +
            "[1518-04-23 00:04] Guard #2251 begins shift\n" +
            "[1518-07-12 00:03] falls asleep\n" +
            "[1518-03-01 00:04] Guard #2971 begins shift\n" +
            "[1518-02-25 00:41] falls asleep\n" +
            "[1518-08-25 00:10] falls asleep\n" +
            "[1518-08-09 00:53] wakes up\n" +
            "[1518-10-28 00:51] wakes up\n" +
            "[1518-05-22 00:12] falls asleep\n" +
            "[1518-05-20 00:58] wakes up\n" +
            "[1518-11-02 00:15] falls asleep\n" +
            "[1518-10-18 23:56] Guard #1637 begins shift\n" +
            "[1518-03-20 00:04] Guard #887 begins shift\n" +
            "[1518-11-14 00:01] Guard #2753 begins shift\n" +
            "[1518-04-11 00:57] wakes up\n" +
            "[1518-03-26 00:42] falls asleep\n" +
            "[1518-04-15 23:53] Guard #1439 begins shift\n" +
            "[1518-08-01 00:11] falls asleep\n" +
            "[1518-05-09 00:25] falls asleep\n" +
            "[1518-06-30 00:04] Guard #1733 begins shift\n" +
            "[1518-06-08 00:54] wakes up\n" +
            "[1518-08-08 00:55] falls asleep\n" +
            "[1518-05-02 00:12] falls asleep\n" +
            "[1518-07-06 00:58] wakes up\n" +
            "[1518-05-29 00:04] Guard #2707 begins shift\n" +
            "[1518-05-09 00:49] wakes up\n" +
            "[1518-03-29 00:02] falls asleep\n" +
            "[1518-08-21 00:36] falls asleep\n" +
            "[1518-10-13 00:29] falls asleep\n" +
            "[1518-07-02 00:53] wakes up\n" +
            "[1518-02-21 00:58] wakes up\n" +
            "[1518-04-30 23:58] Guard #911 begins shift\n" +
            "[1518-03-06 23:56] Guard #2707 begins shift\n" +
            "[1518-03-12 00:36] falls asleep\n" +
            "[1518-04-06 00:42] falls asleep\n" +
            "[1518-09-27 00:59] wakes up\n" +
            "[1518-07-23 00:01] falls asleep\n" +
            "[1518-10-02 00:02] Guard #2971 begins shift\n" +
            "[1518-08-16 00:57] wakes up\n" +
            "[1518-03-13 00:46] wakes up\n" +
            "[1518-06-18 00:09] falls asleep\n" +
            "[1518-02-08 23:57] Guard #1439 begins shift\n" +
            "[1518-04-19 00:52] falls asleep\n" +
            "[1518-08-22 00:06] wakes up\n" +
            "[1518-08-06 23:59] Guard #1999 begins shift\n" +
            "[1518-06-06 00:27] falls asleep\n" +
            "[1518-10-05 00:11] wakes up\n" +
            "[1518-05-01 00:55] falls asleep\n" +
            "[1518-02-22 00:59] wakes up\n" +
            "[1518-04-30 00:08] falls asleep\n" +
            "[1518-04-19 23:47] Guard #3323 begins shift\n" +
            "[1518-04-06 23:50] Guard #3121 begins shift\n" +
            "[1518-04-08 00:21] falls asleep\n" +
            "[1518-11-05 00:49] wakes up\n" +
            "[1518-08-01 00:37] wakes up\n" +
            "[1518-02-26 00:32] falls asleep\n" +
            "[1518-08-30 00:43] wakes up\n" +
            "[1518-11-17 00:09] falls asleep\n" +
            "[1518-07-14 23:59] Guard #2851 begins shift\n" +
            "[1518-06-01 00:36] wakes up\n" +
            "[1518-05-02 00:01] Guard #3121 begins shift\n" +
            "[1518-04-22 00:04] Guard #3121 begins shift\n" +
            "[1518-04-15 00:04] Guard #1637 begins shift\n" +
            "[1518-11-12 00:47] wakes up\n" +
            "[1518-09-13 00:51] falls asleep\n" +
            "[1518-08-06 00:11] falls asleep\n" +
            "[1518-07-11 23:47] Guard #1223 begins shift\n" +
            "[1518-05-07 23:56] Guard #1283 begins shift\n" +
            "[1518-03-28 00:56] falls asleep\n" +
            "[1518-11-09 00:33] wakes up\n" +
            "[1518-08-06 00:57] wakes up\n" +
            "[1518-06-16 00:04] Guard #2851 begins shift\n" +
            "[1518-06-15 00:45] wakes up\n" +
            "[1518-06-27 00:14] falls asleep\n" +
            "[1518-11-07 00:55] wakes up\n" +
            "[1518-05-07 00:54] falls asleep\n" +
            "[1518-02-14 00:01] Guard #2251 begins shift\n" +
            "[1518-08-14 00:12] falls asleep\n" +
            "[1518-09-24 00:59] wakes up\n" +
            "[1518-05-20 00:46] falls asleep\n" +
            "[1518-11-07 00:23] falls asleep\n" +
            "[1518-06-21 00:03] Guard #1637 begins shift\n" +
            "[1518-11-10 00:19] wakes up\n" +
            "[1518-03-24 00:47] wakes up\n" +
            "[1518-09-24 00:44] falls asleep\n" +
            "[1518-04-18 23:57] Guard #3323 begins shift\n" +
            "[1518-10-16 00:59] wakes up\n" +
            "[1518-09-15 00:03] Guard #2971 begins shift\n" +
            "[1518-07-15 00:18] falls asleep\n" +
            "[1518-09-26 00:50] wakes up\n" +
            "[1518-11-06 00:58] wakes up\n" +
            "[1518-09-01 00:44] falls asleep\n" +
            "[1518-05-23 00:24] wakes up\n" +
            "[1518-02-12 00:37] falls asleep\n" +
            "[1518-06-04 00:52] falls asleep\n" +
            "[1518-10-24 00:43] wakes up\n" +
            "[1518-03-12 00:49] wakes up\n" +
            "[1518-05-11 00:44] wakes up\n" +
            "[1518-08-02 00:10] falls asleep\n" +
            "[1518-05-05 23:50] Guard #1213 begins shift\n" +
            "[1518-11-18 00:23] falls asleep\n" +
            "[1518-09-27 23:59] Guard #2707 begins shift\n" +
            "[1518-11-02 00:57] wakes up\n" +
            "[1518-09-26 00:43] falls asleep\n" +
            "[1518-03-08 00:38] falls asleep\n" +
            "[1518-04-05 00:32] falls asleep\n" +
            "[1518-04-13 00:20] falls asleep\n" +
            "[1518-09-25 00:26] falls asleep\n" +
            "[1518-06-09 00:20] falls asleep\n" +
            "[1518-04-01 00:53] falls asleep\n" +
            "[1518-07-12 00:35] falls asleep\n" +
            "[1518-07-12 00:40] wakes up\n" +
            "[1518-03-04 00:10] falls asleep\n" +
            "[1518-06-22 00:00] Guard #3023 begins shift\n" +
            "[1518-02-23 00:44] wakes up\n" +
            "[1518-09-11 00:04] Guard #1637 begins shift\n" +
            "[1518-06-01 00:03] falls asleep\n" +
            "[1518-02-21 00:38] falls asleep\n" +
            "[1518-03-30 23:59] Guard #233 begins shift\n" +
            "[1518-08-27 00:48] falls asleep\n" +
            "[1518-03-10 23:59] Guard #2251 begins shift\n" +
            "[1518-02-15 00:34] falls asleep\n" +
            "[1518-09-16 00:02] falls asleep\n" +
            "[1518-04-25 00:49] wakes up\n" +
            "[1518-04-01 23:56] Guard #2851 begins shift\n" +
            "[1518-04-14 00:56] wakes up\n" +
            "[1518-09-10 00:38] falls asleep\n" +
            "[1518-02-23 23:49] Guard #1283 begins shift\n" +
            "[1518-11-21 23:59] Guard #3121 begins shift\n" +
            "[1518-05-28 00:17] falls asleep\n" +
            "[1518-05-22 00:19] wakes up\n" +
            "[1518-11-11 00:00] Guard #1283 begins shift\n" +
            "[1518-05-27 00:35] falls asleep\n" +
            "[1518-03-30 00:24] falls asleep\n" +
            "[1518-10-06 00:57] wakes up\n" +
            "[1518-10-11 00:51] falls asleep\n" +
            "[1518-06-23 00:00] Guard #3121 begins shift\n" +
            "[1518-08-02 00:53] wakes up\n" +
            "[1518-08-17 00:42] wakes up\n" +
            "[1518-05-02 00:54] wakes up\n" +
            "[1518-04-13 23:59] Guard #1231 begins shift\n" +
            "[1518-10-27 00:10] falls asleep\n" +
            "[1518-07-28 00:44] falls asleep\n" +
            "[1518-10-05 00:21] falls asleep\n" +
            "[1518-07-18 00:24] falls asleep\n" +
            "[1518-06-12 00:58] wakes up\n" +
            "[1518-10-15 00:01] Guard #3121 begins shift\n" +
            "[1518-08-11 00:28] falls asleep\n" +
            "[1518-03-21 00:37] falls asleep\n" +
            "[1518-05-24 00:27] falls asleep\n" +
            "[1518-10-03 00:37] wakes up\n" +
            "[1518-05-27 00:00] Guard #1283 begins shift\n" +
            "[1518-11-14 00:51] wakes up\n" +
            "[1518-04-12 00:55] wakes up\n" +
            "[1518-06-21 00:50] wakes up\n" +
            "[1518-03-27 00:33] falls asleep\n" +
            "[1518-05-19 00:52] wakes up\n" +
            "[1518-10-12 00:21] falls asleep\n" +
            "[1518-03-26 00:59] wakes up\n" +
            "[1518-07-20 00:36] wakes up\n" +
            "[1518-07-25 00:03] Guard #2251 begins shift\n" +
            "[1518-03-11 00:24] falls asleep\n" +
            "[1518-10-07 00:58] wakes up\n" +
            "[1518-06-29 00:49] falls asleep\n" +
            "[1518-07-14 00:57] wakes up\n" +
            "[1518-11-03 23:57] Guard #2707 begins shift\n" +
            "[1518-05-16 00:15] falls asleep\n" +
            "[1518-02-10 00:28] falls asleep\n" +
            "[1518-08-28 00:00] Guard #3023 begins shift\n" +
            "[1518-11-08 00:44] wakes up\n" +
            "[1518-05-01 00:35] wakes up\n" +
            "[1518-10-20 00:12] falls asleep\n" +
            "[1518-03-21 00:00] Guard #859 begins shift\n" +
            "[1518-04-16 00:16] falls asleep\n" +
            "[1518-07-10 00:44] falls asleep\n" +
            "[1518-02-22 23:59] Guard #1439 begins shift\n" +
            "[1518-06-24 00:57] wakes up\n" +
            "[1518-05-23 00:28] falls asleep\n" +
            "[1518-07-04 00:03] Guard #3023 begins shift\n" +
            "[1518-06-19 00:01] Guard #2707 begins shift\n" +
            "[1518-06-04 00:47] wakes up\n" +
            "[1518-09-03 00:57] wakes up\n" +
            "[1518-04-08 00:46] falls asleep\n" +
            "[1518-04-10 00:24] falls asleep\n" +
            "[1518-04-26 00:36] wakes up\n" +
            "[1518-03-02 00:58] wakes up\n" +
            "[1518-10-25 00:51] wakes up\n" +
            "[1518-04-04 00:03] falls asleep\n" +
            "[1518-06-04 23:59] Guard #859 begins shift\n" +
            "[1518-10-21 00:50] wakes up\n" +
            "[1518-02-28 00:48] wakes up\n" +
            "[1518-06-15 00:39] falls asleep\n" +
            "[1518-09-20 00:53] wakes up\n" +
            "[1518-04-06 00:51] wakes up\n" +
            "[1518-08-28 23:52] Guard #1283 begins shift\n" +
            "[1518-07-24 00:11] falls asleep\n" +
            "[1518-07-17 00:54] falls asleep\n" +
            "[1518-06-05 00:42] wakes up\n" +
            "[1518-09-22 00:23] wakes up\n" +
            "[1518-11-11 00:25] falls asleep\n" +
            "[1518-08-04 00:35] wakes up\n" +
            "[1518-08-05 23:59] Guard #859 begins shift\n" +
            "[1518-10-23 00:41] falls asleep\n" +
            "[1518-11-19 00:04] falls asleep\n" +
            "[1518-06-20 00:25] falls asleep\n" +
            "[1518-11-11 00:52] falls asleep\n" +
            "[1518-04-07 00:02] falls asleep\n" +
            "[1518-07-21 23:59] Guard #3023 begins shift\n" +
            "[1518-11-18 00:00] Guard #3323 begins shift\n" +
            "[1518-04-24 00:01] Guard #233 begins shift\n" +
            "[1518-11-03 00:56] falls asleep\n" +
            "[1518-09-30 23:59] Guard #2903 begins shift\n" +
            "[1518-09-17 23:58] Guard #3323 begins shift\n" +
            "[1518-10-31 00:42] falls asleep\n" +
            "[1518-02-09 23:58] Guard #1439 begins shift\n" +
            "[1518-09-06 00:55] wakes up\n" +
            "[1518-04-26 00:30] falls asleep\n" +
            "[1518-03-24 00:37] falls asleep\n" +
            "[1518-03-05 23:57] Guard #3023 begins shift\n" +
            "[1518-02-16 00:23] wakes up\n" +
            "[1518-09-18 00:10] falls asleep\n" +
            "[1518-04-18 00:38] falls asleep\n" +
            "[1518-08-09 00:26] falls asleep\n" +
            "[1518-07-06 00:17] wakes up\n" +
            "[1518-09-22 00:52] falls asleep\n" +
            "[1518-07-07 00:49] wakes up\n" +
            "[1518-10-04 00:02] Guard #1637 begins shift\n" +
            "[1518-02-11 00:01] Guard #3323 begins shift\n" +
            "[1518-07-21 00:39] falls asleep\n" +
            "[1518-06-12 00:17] falls asleep\n" +
            "[1518-07-20 23:58] Guard #3323 begins shift\n" +
            "[1518-04-16 00:04] wakes up\n" +
            "[1518-05-20 00:00] Guard #3323 begins shift\n" +
            "[1518-10-10 00:45] wakes up\n" +
            "[1518-03-03 00:57] wakes up\n" +
            "[1518-04-18 00:24] wakes up\n" +
            "[1518-04-19 00:57] wakes up\n" +
            "[1518-11-20 23:59] Guard #1439 begins shift\n" +
            "[1518-07-27 00:30] wakes up\n" +
            "[1518-09-07 00:52] wakes up\n" +
            "[1518-06-18 00:55] falls asleep\n" +
            "[1518-02-15 23:59] Guard #1213 begins shift\n" +
            "[1518-11-02 00:51] wakes up\n" +
            "[1518-10-11 00:02] falls asleep\n" +
            "[1518-10-07 00:32] falls asleep\n" +
            "[1518-06-07 00:43] falls asleep\n" +
            "[1518-07-15 00:56] wakes up\n" +
            "[1518-06-27 00:53] wakes up\n" +
            "[1518-06-29 00:50] wakes up\n" +
            "[1518-07-04 00:38] falls asleep\n" +
            "[1518-07-13 23:50] Guard #2753 begins shift\n" +
            "[1518-06-19 00:49] wakes up\n" +
            "[1518-09-02 23:53] Guard #2851 begins shift\n" +
            "[1518-02-26 23:58] Guard #2251 begins shift\n" +
            "[1518-03-14 00:13] falls asleep\n" +
            "[1518-07-17 00:42] falls asleep\n" +
            "[1518-02-19 00:04] falls asleep\n" +
            "[1518-05-18 23:57] Guard #1231 begins shift\n" +
            "[1518-03-04 23:54] Guard #1223 begins shift\n" +
            "[1518-09-12 00:29] wakes up\n" +
            "[1518-10-15 00:53] falls asleep\n" +
            "[1518-11-06 23:57] Guard #887 begins shift\n" +
            "[1518-08-11 00:47] wakes up\n" +
            "[1518-02-20 23:57] Guard #3323 begins shift\n" +
            "[1518-05-28 00:49] falls asleep\n" +
            "[1518-09-27 00:46] falls asleep\n" +
            "[1518-04-29 00:47] wakes up\n" +
            "[1518-03-03 00:50] falls asleep\n" +
            "[1518-07-07 00:19] falls asleep\n" +
            "[1518-08-20 00:28] falls asleep\n" +
            "[1518-08-25 00:53] falls asleep\n" +
            "[1518-10-04 23:50] Guard #2903 begins shift\n" +
            "[1518-06-20 00:03] Guard #3323 begins shift\n" +
            "[1518-10-08 23:56] Guard #2903 begins shift\n" +
            "[1518-08-15 00:59] wakes up\n" +
            "[1518-05-18 00:43] wakes up\n" +
            "[1518-02-21 00:45] wakes up\n" +
            "[1518-05-19 00:29] wakes up\n" +
            "[1518-02-11 00:40] wakes up\n" +
            "[1518-04-22 00:22] falls asleep\n" +
            "[1518-09-06 00:50] wakes up\n" +
            "[1518-09-07 00:02] Guard #1283 begins shift\n" +
            "[1518-10-28 23:56] Guard #859 begins shift\n" +
            "[1518-09-21 00:34] falls asleep\n" +
            "[1518-09-02 00:41] wakes up\n" +
            "[1518-02-17 00:58] wakes up\n" +
            "[1518-09-01 00:04] Guard #1223 begins shift\n" +
            "[1518-03-02 23:48] Guard #2851 begins shift\n" +
            "[1518-05-02 00:47] falls asleep\n" +
            "[1518-04-22 00:07] falls asleep\n" +
            "[1518-06-24 00:43] wakes up\n" +
            "[1518-05-28 00:46] wakes up\n" +
            "[1518-08-24 00:59] wakes up\n" +
            "[1518-05-05 00:54] wakes up\n" +
            "[1518-02-08 00:00] Guard #1439 begins shift\n" +
            "[1518-04-01 00:01] Guard #2851 begins shift\n" +
            "[1518-11-08 23:51] Guard #1283 begins shift\n" +
            "[1518-07-01 00:46] wakes up\n" +
            "[1518-10-26 00:03] Guard #887 begins shift\n" +
            "[1518-03-24 00:12] wakes up\n" +
            "[1518-07-06 23:59] Guard #2971 begins shift\n" +
            "[1518-08-04 00:22] falls asleep\n" +
            "[1518-04-10 23:56] Guard #2903 begins shift\n" +
            "[1518-11-18 00:50] wakes up\n" +
            "[1518-11-13 00:00] Guard #1733 begins shift\n" +
            "[1518-10-05 00:51] wakes up\n" +
            "[1518-06-23 00:48] falls asleep\n" +
            "[1518-03-28 23:53] Guard #1213 begins shift\n" +
            "[1518-05-05 00:47] wakes up\n" +
            "[1518-06-26 00:37] falls asleep\n" +
            "[1518-04-08 00:51] wakes up\n" +
            "[1518-11-09 23:59] Guard #2707 begins shift\n" +
            "[1518-05-02 00:42] wakes up\n" +
            "[1518-11-13 00:45] falls asleep\n" +
            "[1518-05-23 00:55] wakes up\n" +
            "[1518-05-14 23:57] Guard #859 begins shift\n" +
            "[1518-05-04 00:57] wakes up\n" +
            "[1518-08-25 00:56] wakes up\n" +
            "[1518-10-19 23:58] Guard #3023 begins shift\n" +
            "[1518-10-29 23:58] Guard #1213 begins shift\n" +
            "[1518-09-14 00:55] falls asleep\n" +
            "[1518-02-22 00:45] falls asleep\n" +
            "[1518-10-22 00:03] Guard #2971 begins shift\n" +
            "[1518-08-10 00:54] wakes up\n" +
            "[1518-10-07 00:54] falls asleep\n" +
            "[1518-08-27 00:52] wakes up\n" +
            "[1518-06-15 00:02] Guard #2251 begins shift\n" +
            "[1518-06-02 00:51] wakes up\n" +
            "[1518-06-24 00:47] falls asleep\n" +
            "[1518-03-21 23:56] Guard #887 begins shift\n" +
            "[1518-06-09 23:50] Guard #3023 begins shift\n" +
            "[1518-02-17 00:13] falls asleep\n" +
            "[1518-02-21 00:49] falls asleep\n" +
            "[1518-08-18 00:00] Guard #2707 begins shift\n" +
            "[1518-07-17 00:02] falls asleep\n" +
            "[1518-07-13 00:52] wakes up\n" +
            "[1518-02-12 00:55] falls asleep\n" +
            "[1518-07-15 23:58] Guard #1231 begins shift\n" +
            "[1518-05-25 00:43] wakes up\n" +
            "[1518-06-24 00:01] falls asleep\n" +
            "[1518-06-22 00:56] wakes up\n" +
            "[1518-10-03 00:08] falls asleep\n" +
            "[1518-06-14 00:56] wakes up\n" +
            "[1518-07-13 00:27] falls asleep\n" +
            "[1518-11-11 00:43] wakes up\n" +
            "[1518-09-26 00:56] falls asleep\n" +
            "[1518-08-20 00:44] wakes up\n" +
            "[1518-08-29 00:05] falls asleep\n" +
            "[1518-10-07 00:50] falls asleep\n" +
            "[1518-08-24 00:47] falls asleep\n" +
            "[1518-02-18 23:51] Guard #2753 begins shift\n" +
            "[1518-03-12 00:18] wakes up\n" +
            "[1518-05-16 00:02] Guard #887 begins shift\n" +
            "[1518-11-14 23:58] Guard #859 begins shift\n" +
            "[1518-03-24 00:07] falls asleep\n" +
            "[1518-08-28 00:47] wakes up\n" +
            "[1518-04-13 00:03] Guard #1733 begins shift\n" +
            "[1518-09-11 00:18] falls asleep\n" +
            "[1518-05-04 00:43] falls asleep\n" +
            "[1518-09-20 23:57] Guard #887 begins shift\n" +
            "[1518-10-16 00:45] falls asleep\n" +
            "[1518-08-25 00:31] wakes up\n" +
            "[1518-10-25 00:17] falls asleep\n" +
            "[1518-03-21 00:21] falls asleep\n" +
            "[1518-08-29 23:57] Guard #1733 begins shift\n" +
            "[1518-04-26 00:13] falls asleep\n" +
            "[1518-03-08 00:29] wakes up\n" +
            "[1518-04-20 00:56] wakes up\n" +
            "[1518-06-02 00:00] Guard #887 begins shift\n" +
            "[1518-05-27 00:15] wakes up\n" +
            "[1518-10-08 00:01] falls asleep\n" +
            "[1518-05-30 23:56] Guard #2753 begins shift\n" +
            "[1518-03-03 00:00] falls asleep\n" +
            "[1518-02-28 00:28] wakes up\n" +
            "[1518-03-01 23:59] Guard #1597 begins shift\n" +
            "[1518-03-01 00:23] falls asleep\n" +
            "[1518-10-18 00:53] wakes up\n" +
            "[1518-02-21 23:58] Guard #1733 begins shift\n" +
            "[1518-04-03 23:52] Guard #2753 begins shift\n" +
            "[1518-07-22 00:36] falls asleep\n" +
            "[1518-06-13 00:24] falls asleep\n" +
            "[1518-05-18 00:04] Guard #1231 begins shift\n" +
            "[1518-06-28 00:15] falls asleep\n" +
            "[1518-11-20 00:00] Guard #911 begins shift\n" +
            "[1518-07-23 00:39] wakes up\n" +
            "[1518-09-25 23:58] Guard #1213 begins shift\n" +
            "[1518-10-14 00:36] wakes up\n" +
            "[1518-08-05 00:23] falls asleep\n" +
            "[1518-09-04 00:49] wakes up\n" +
            "[1518-06-25 00:23] falls asleep\n" +
            "[1518-10-19 00:51] falls asleep\n" +
            "[1518-08-08 00:04] Guard #2903 begins shift\n" +
            "[1518-08-26 00:50] wakes up\n" +
            "[1518-09-17 00:53] wakes up\n" +
            "[1518-03-14 00:00] Guard #2971 begins shift\n" +
            "[1518-09-30 00:03] falls asleep\n" +
            "[1518-07-17 00:49] wakes up\n" +
            "[1518-10-01 00:46] wakes up\n" +
            "[1518-02-10 00:42] wakes up\n" +
            "[1518-10-06 23:51] Guard #887 begins shift\n" +
            "[1518-02-25 23:57] Guard #1733 begins shift\n" +
            "[1518-05-28 00:24] wakes up\n" +
            "[1518-05-16 00:42] wakes up\n" +
            "[1518-07-17 00:24] wakes up\n" +
            "[1518-05-02 00:48] wakes up\n" +
            "[1518-06-05 00:50] falls asleep\n" +
            "[1518-05-06 23:59] Guard #2251 begins shift\n" +
            "[1518-03-16 00:28] falls asleep\n" +
            "[1518-03-08 00:45] wakes up\n" +
            "[1518-04-02 00:53] wakes up\n" +
            "[1518-04-19 00:56] falls asleep\n" +
            "[1518-09-13 00:19] wakes up\n" +
            "[1518-07-02 00:32] falls asleep\n" +
            "[1518-10-25 00:22] wakes up\n" +
            "[1518-06-07 00:33] falls asleep\n" +
            "[1518-09-19 23:49] Guard #1597 begins shift\n" +
            "[1518-09-14 00:59] wakes up\n" +
            "[1518-03-24 00:52] falls asleep\n" +
            "[1518-05-24 00:51] wakes up\n" +
            "[1518-09-09 00:04] Guard #2251 begins shift\n" +
            "[1518-08-26 00:27] falls asleep\n" +
            "[1518-04-02 00:58] wakes up\n" +
            "[1518-06-23 00:50] wakes up\n" +
            "[1518-06-17 00:20] falls asleep\n" +
            "[1518-08-14 00:55] wakes up\n" +
            "[1518-04-02 00:23] falls asleep\n" +
            "[1518-03-07 23:46] Guard #1223 begins shift\n" +
            "[1518-02-16 00:08] falls asleep\n" +
            "[1518-03-29 00:48] wakes up\n" +
            "[1518-08-11 00:52] falls asleep\n" +
            "[1518-11-19 00:58] wakes up\n" +
            "[1518-04-25 23:56] Guard #1637 begins shift\n" +
            "[1518-05-07 00:44] wakes up\n" +
            "[1518-07-18 00:02] Guard #1439 begins shift\n" +
            "[1518-09-15 00:36] falls asleep\n" +
            "[1518-03-30 00:02] Guard #3121 begins shift\n" +
            "[1518-07-19 00:26] falls asleep\n" +
            "[1518-05-06 00:02] falls asleep\n" +
            "[1518-04-09 00:45] wakes up\n" +
            "[1518-05-28 00:58] wakes up\n" +
            "[1518-08-04 00:01] Guard #1439 begins shift\n" +
            "[1518-05-22 23:59] Guard #1213 begins shift\n" +
            "[1518-05-25 00:20] falls asleep\n" +
            "[1518-10-12 00:55] wakes up\n" +
            "[1518-08-29 00:25] falls asleep\n" +
            "[1518-07-10 00:28] wakes up\n" +
            "[1518-10-12 00:36] wakes up\n" +
            "[1518-11-16 23:58] Guard #859 begins shift\n" +
            "[1518-10-29 00:53] falls asleep\n" +
            "[1518-06-05 00:41] falls asleep\n" +
            "[1518-08-25 00:00] Guard #887 begins shift\n" +
            "[1518-09-10 00:46] wakes up\n" +
            "[1518-03-14 00:49] wakes up\n" +
            "[1518-04-23 00:11] falls asleep\n" +
            "[1518-08-19 00:42] falls asleep\n" +
            "[1518-03-23 00:33] wakes up\n" +
            "[1518-09-30 00:46] wakes up\n" +
            "[1518-08-30 23:56] Guard #3121 begins shift\n" +
            "[1518-11-03 00:10] falls asleep\n" +
            "[1518-08-21 00:01] Guard #887 begins shift\n" +
            "[1518-02-11 00:21] falls asleep\n" +
            "[1518-07-06 00:01] falls asleep\n" +
            "[1518-11-06 00:40] falls asleep\n" +
            "[1518-02-21 00:50] wakes up\n" +
            "[1518-03-28 00:57] wakes up\n" +
            "[1518-10-26 00:58] wakes up\n" +
            "[1518-10-22 23:56] Guard #2903 begins shift\n" +
            "[1518-06-06 00:54] wakes up\n" +
            "[1518-10-24 00:28] falls asleep\n" +
            "[1518-02-11 23:56] Guard #2251 begins shift\n" +
            "[1518-06-12 23:58] Guard #3023 begins shift\n" +
            "[1518-03-04 00:55] falls asleep\n" +
            "[1518-02-12 00:58] wakes up\n" +
            "[1518-06-05 00:57] wakes up\n" +
            "[1518-04-09 00:55] falls asleep\n" +
            "[1518-03-15 00:46] falls asleep\n" +
            "[1518-04-25 00:48] falls asleep\n" +
            "[1518-06-05 23:57] Guard #2753 begins shift\n" +
            "[1518-04-28 00:23] falls asleep\n" +
            "[1518-07-27 00:55] wakes up\n" +
            "[1518-03-23 00:05] falls asleep\n" +
            "[1518-05-26 00:03] Guard #233 begins shift\n" +
            "[1518-10-07 00:00] falls asleep\n" +
            "[1518-02-24 23:53] Guard #2971 begins shift\n" +
            "[1518-10-03 00:00] Guard #2251 begins shift\n" +
            "[1518-08-05 00:45] falls asleep\n" +
            "[1518-04-28 00:58] wakes up\n" +
            "[1518-04-17 00:23] falls asleep\n" +
            "[1518-07-30 00:13] falls asleep\n" +
            "[1518-06-06 00:48] falls asleep\n" +
            "[1518-05-07 00:58] wakes up\n" +
            "[1518-07-29 00:46] falls asleep\n" +
            "[1518-05-24 00:02] Guard #2903 begins shift\n" +
            "[1518-03-18 00:04] Guard #1733 begins shift\n" +
            "[1518-04-12 00:17] wakes up\n" +
            "[1518-04-27 23:59] Guard #2707 begins shift\n" +
            "[1518-07-01 23:59] Guard #2707 begins shift\n" +
            "[1518-10-10 00:09] falls asleep\n" +
            "[1518-05-11 23:56] Guard #3323 begins shift\n" +
            "[1518-02-27 00:30] falls asleep\n" +
            "[1518-04-17 00:42] wakes up\n" +
            "[1518-06-26 23:58] Guard #2903 begins shift\n" +
            "[1518-05-20 23:58] Guard #1597 begins shift\n" +
            "[1518-07-09 00:50] wakes up\n" +
            "[1518-02-09 00:56] falls asleep\n" +
            "[1518-05-11 00:34] falls asleep\n" +
            "[1518-06-13 00:52] wakes up\n" +
            "[1518-02-24 00:19] wakes up\n" +
            "[1518-06-19 00:23] falls asleep\n" +
            "[1518-03-25 00:30] falls asleep\n" +
            "[1518-02-28 00:40] falls asleep\n" +
            "[1518-09-19 00:32] wakes up\n" +
            "[1518-05-19 00:43] falls asleep\n" +
            "[1518-05-07 00:37] falls asleep\n" +
            "[1518-07-01 00:13] falls asleep\n" +
            "[1518-09-14 00:03] Guard #911 begins shift\n" +
            "[1518-04-19 00:49] wakes up\n" +
            "[1518-10-25 00:59] wakes up\n" +
            "[1518-07-18 00:49] wakes up\n" +
            "[1518-03-10 00:00] Guard #3449 begins shift\n" +
            "[1518-04-18 00:00] Guard #3121 begins shift\n" +
            "[1518-10-05 00:05] falls asleep\n" +
            "[1518-06-28 00:43] wakes up\n" +
            "[1518-11-06 00:16] falls asleep\n" +
            "[1518-09-26 00:16] falls asleep\n" +
            "[1518-05-15 00:46] falls asleep\n" +
            "[1518-10-10 00:55] falls asleep\n" +
            "[1518-11-22 00:49] falls asleep\n" +
            "[1518-08-19 00:02] Guard #1223 begins shift\n" +
            "[1518-10-10 00:03] Guard #2251 begins shift\n" +
            "[1518-10-31 00:57] wakes up\n" +
            "[1518-11-08 00:16] wakes up\n" +
            "[1518-10-25 00:01] Guard #1213 begins shift\n" +
            "[1518-03-18 23:56] Guard #859 begins shift\n" +
            "[1518-06-02 23:48] Guard #2753 begins shift\n" +
            "[1518-09-15 00:51] wakes up\n" +
            "[1518-10-15 00:27] falls asleep\n" +
            "[1518-02-14 00:50] wakes up\n" +
            "[1518-03-19 00:37] wakes up\n" +
            "[1518-09-18 00:42] wakes up\n" +
            "[1518-10-06 00:01] Guard #1733 begins shift\n" +
            "[1518-03-20 00:40] falls asleep\n" +
            "[1518-09-29 00:37] falls asleep\n" +
            "[1518-07-27 00:36] falls asleep\n" +
            "[1518-10-27 23:59] Guard #911 begins shift\n" +
            "[1518-10-16 00:56] falls asleep\n" +
            "[1518-10-21 00:28] falls asleep\n" +
            "[1518-07-16 23:53] Guard #1597 begins shift\n" +
            "[1518-05-17 00:25] falls asleep\n" +
            "[1518-08-22 00:04] falls asleep\n" +
            "[1518-11-03 00:04] Guard #2971 begins shift\n" +
            "[1518-10-10 00:20] wakes up\n" +
            "[1518-05-11 00:52] falls asleep\n" +
            "[1518-08-03 00:54] wakes up\n" +
            "[1518-09-13 00:59] wakes up\n" +
            "[1518-08-11 23:59] Guard #1213 begins shift\n" +
            "[1518-11-13 00:47] wakes up\n" +
            "[1518-04-27 00:03] falls asleep\n" +
            "[1518-10-10 00:57] wakes up\n" +
            "[1518-05-27 00:41] wakes up\n" +
            "[1518-09-02 00:23] falls asleep\n" +
            "[1518-09-01 00:30] wakes up\n" +
            "[1518-06-21 00:48] falls asleep\n" +
            "[1518-03-19 00:35] falls asleep\n" +
            "[1518-09-12 00:49] wakes up\n" +
            "[1518-07-12 00:09] wakes up\n" +
            "[1518-06-06 23:56] Guard #3323 begins shift\n" +
            "[1518-09-21 00:55] wakes up\n" +
            "[1518-05-03 00:39] falls asleep\n" +
            "[1518-07-08 00:57] wakes up\n" +
            "[1518-07-28 00:35] wakes up\n" +
            "[1518-04-23 00:24] wakes up\n" +
            "[1518-03-04 00:04] Guard #1733 begins shift\n" +
            "[1518-06-11 00:18] falls asleep\n" +
            "[1518-05-09 00:17] wakes up\n" +
            "[1518-06-17 23:57] Guard #3121 begins shift\n" +
            "[1518-08-15 00:41] falls asleep\n" +
            "[1518-03-15 00:12] falls asleep\n" +
            "[1518-02-16 23:59] Guard #2753 begins shift\n" +
            "[1518-11-08 00:13] falls asleep\n" +
            "[1518-07-06 00:55] falls asleep\n" +
            "[1518-02-21 00:54] falls asleep\n" +
            "[1518-07-10 00:11] falls asleep\n" +
            "[1518-05-03 00:58] wakes up\n" +
            "[1518-10-08 00:41] wakes up\n" +
            "[1518-07-19 23:59] Guard #3121 begins shift\n" +
            "[1518-09-14 00:23] falls asleep\n" +
            "[1518-07-23 00:29] falls asleep\n" +
            "[1518-05-13 00:42] falls asleep\n" +
            "[1518-07-13 00:47] falls asleep\n" +
            "[1518-04-04 23:57] Guard #1439 begins shift\n" +
            "[1518-07-16 00:57] wakes up\n" +
            "[1518-06-25 00:01] Guard #2903 begins shift\n" +
            "[1518-05-30 00:03] Guard #3121 begins shift\n" +
            "[1518-10-09 00:41] wakes up\n" +
            "[1518-10-19 00:58] wakes up\n" +
            "[1518-08-31 00:51] falls asleep\n" +
            "[1518-04-27 00:47] falls asleep\n" +
            "[1518-11-01 00:37] wakes up\n" +
            "[1518-03-07 00:25] wakes up\n" +
            "[1518-08-16 00:35] wakes up\n" +
            "[1518-11-16 00:04] Guard #1439 begins shift\n" +
            "[1518-08-14 00:00] Guard #3023 begins shift\n" +
            "[1518-04-04 00:38] wakes up\n" +
            "[1518-06-18 00:56] wakes up\n" +
            "[1518-10-12 00:47] wakes up\n" +
            "[1518-10-07 00:35] wakes up\n" +
            "[1518-10-29 00:59] wakes up\n" +
            "[1518-07-08 00:42] falls asleep\n" +
            "[1518-04-06 00:04] Guard #1223 begins shift\n" +
            "[1518-06-10 00:03] falls asleep\n" +
            "[1518-05-25 00:55] wakes up\n" +
            "[1518-06-27 23:53] Guard #1213 begins shift\n" +
            "[1518-06-04 00:55] wakes up\n" +
            "[1518-11-09 00:36] falls asleep\n" +
            "[1518-07-11 00:02] Guard #1439 begins shift\n" +
            "[1518-11-12 00:29] falls asleep\n" +
            "[1518-06-10 00:35] wakes up\n" +
            "[1518-02-15 00:41] wakes up\n" +
            "[1518-06-09 00:51] wakes up\n" +
            "[1518-04-15 00:33] falls asleep\n" +
            "[1518-05-29 00:57] wakes up\n" +
            "[1518-10-09 00:46] falls asleep\n" +
            "[1518-11-16 00:36] wakes up\n" +
            "[1518-07-31 00:04] Guard #3023 begins shift\n" +
            "[1518-10-07 00:51] wakes up\n" +
            "[1518-10-23 23:58] Guard #2851 begins shift\n" +
            "[1518-11-17 00:48] falls asleep\n" +
            "[1518-06-14 00:25] falls asleep\n" +
            "[1518-05-19 00:14] falls asleep\n" +
            "[1518-05-05 00:18] falls asleep\n" +
            "[1518-06-03 00:41] wakes up\n" +
            "[1518-09-29 00:01] Guard #3023 begins shift\n" +
            "[1518-10-31 00:20] wakes up\n" +
            "[1518-05-28 00:35] falls asleep\n" +
            "[1518-10-04 00:53] wakes up\n" +
            "[1518-03-26 00:02] Guard #2851 begins shift\n" +
            "[1518-06-07 00:36] wakes up\n" +
            "[1518-04-08 00:43] wakes up\n" +
            "[1518-04-15 00:21] wakes up\n" +
            "[1518-08-18 00:59] wakes up\n" +
            "[1518-08-23 00:00] Guard #233 begins shift\n" +
            "[1518-04-09 00:12] falls asleep\n" +
            "[1518-08-05 00:14] wakes up\n" +
            "[1518-07-03 00:45] wakes up\n" +
            "[1518-11-23 00:57] wakes up\n" +
            "[1518-03-21 00:24] wakes up\n" +
            "[1518-07-09 00:29] falls asleep\n" +
            "[1518-07-06 00:51] wakes up\n" +
            "[1518-03-25 00:02] Guard #911 begins shift\n" +
            "[1518-08-05 00:38] wakes up\n" +
            "[1518-04-26 23:48] Guard #1213 begins shift\n" +
            "[1518-06-13 23:56] Guard #887 begins shift\n" +
            "[1518-10-19 00:56] falls asleep\n" +
            "[1518-10-28 00:46] falls asleep\n" +
            "[1518-06-14 00:12] falls asleep\n" +
            "[1518-11-09 00:40] wakes up\n" +
            "[1518-02-09 00:57] wakes up\n" +
            "[1518-09-24 00:50] falls asleep\n" +
            "[1518-10-20 00:48] wakes up\n" +
            "[1518-09-07 00:07] falls asleep\n" +
            "[1518-09-01 00:54] wakes up\n" +
            "[1518-07-26 00:55] wakes up\n" +
            "[1518-05-12 00:44] wakes up\n" +
            "[1518-04-17 00:01] Guard #2851 begins shift\n" +
            "[1518-06-03 00:05] falls asleep\n" +
            "[1518-06-04 00:25] falls asleep\n" +
            "[1518-02-16 00:59] wakes up\n" +
            "[1518-05-02 23:59] Guard #1231 begins shift\n" +
            "[1518-04-16 00:00] falls asleep\n" +
            "[1518-06-26 00:47] wakes up\n" +
            "[1518-10-02 00:47] wakes up\n" +
            "[1518-08-24 00:40] falls asleep\n" +
            "[1518-07-08 00:22] falls asleep\n" +
            "[1518-11-11 23:57] Guard #1283 begins shift\n" +
            "[1518-11-21 00:57] wakes up\n" +
            "[1518-03-11 23:47] Guard #1223 begins shift\n" +
            "[1518-02-17 00:27] wakes up\n" +
            "[1518-08-17 00:02] Guard #1597 begins shift\n" +
            "[1518-08-30 00:56] falls asleep\n" +
            "[1518-08-31 00:36] wakes up\n" +
            "[1518-04-27 00:24] falls asleep\n" +
            "[1518-10-07 00:21] wakes up\n" +
            "[1518-11-05 00:03] Guard #1637 begins shift\n" +
            "[1518-06-29 00:44] wakes up\n" +
            "[1518-08-16 00:02] Guard #2851 begins shift\n" +
            "[1518-04-27 00:59] wakes up\n" +
            "[1518-09-22 00:59] wakes up\n" +
            "[1518-04-26 00:16] wakes up\n" +
            "[1518-08-29 00:59] wakes up\n" +
            "[1518-09-12 23:59] Guard #1637 begins shift\n" +
            "[1518-07-13 00:36] wakes up\n" +
            "[1518-11-04 00:14] falls asleep\n" +
            "[1518-11-02 00:03] Guard #2251 begins shift\n" +
            "[1518-02-09 00:53] wakes up\n" +
            "[1518-08-10 00:34] falls asleep\n" +
            "[1518-11-09 00:00] falls asleep\n" +
            "[1518-03-08 00:17] falls asleep\n" +
            "[1518-03-08 00:05] wakes up\n" +
            "[1518-10-12 00:50] falls asleep\n" +
            "[1518-06-29 00:04] Guard #3323 begins shift\n" +
            "[1518-07-26 23:52] Guard #1597 begins shift\n" +
            "[1518-03-01 00:55] wakes up\n" +
            "[1518-02-28 00:02] Guard #2903 begins shift\n" +
            "[1518-05-11 00:55] wakes up\n" +
            "[1518-07-04 23:56] Guard #3449 begins shift\n" +
            "[1518-03-05 00:04] falls asleep\n" +
            "[1518-09-09 00:13] falls asleep\n" +
            "[1518-08-24 00:04] Guard #2851 begins shift\n" +
            "[1518-05-27 00:12] falls asleep\n" +
            "[1518-07-22 00:58] wakes up\n" +
            "[1518-10-18 00:04] Guard #2903 begins shift\n" +
            "[1518-09-12 00:00] Guard #2753 begins shift\n" +
            "[1518-09-26 23:59] Guard #2707 begins shift\n" +
            "[1518-08-16 00:53] falls asleep\n" +
            "[1518-09-21 23:58] Guard #1213 begins shift\n" +
            "[1518-11-03 00:45] wakes up\n" +
            "[1518-08-31 00:57] wakes up\n" +
            "[1518-04-15 00:15] falls asleep\n" +
            "[1518-08-06 00:13] wakes up\n" +
            "[1518-08-21 23:50] Guard #3323 begins shift\n" +
            "[1518-10-11 23:57] Guard #911 begins shift";

    private String testInput = "[1518-11-01 00:00] Guard #10 begins shift\n" +
            "[1518-11-01 00:05] falls asleep\n" +
            "[1518-11-01 00:25] wakes up\n" +
            "[1518-11-01 00:30] falls asleep\n" +
            "[1518-11-01 00:55] wakes up\n" +
            "[1518-11-01 23:58] Guard #99 begins shift\n" +
            "[1518-11-02 00:40] falls asleep\n" +
            "[1518-11-02 00:50] wakes up\n" +
            "[1518-11-03 00:05] Guard #10 begins shift\n" +
            "[1518-11-03 00:24] falls asleep\n" +
            "[1518-11-03 00:29] wakes up\n" +
            "[1518-11-04 00:02] Guard #99 begins shift\n" +
            "[1518-11-04 00:36] falls asleep\n" +
            "[1518-11-04 00:46] wakes up\n" +
            "[1518-11-05 00:03] Guard #99 begins shift\n" +
            "[1518-11-05 00:45] falls asleep\n" +
            "[1518-11-05 00:55] wakes up";

    @Test
    public void testPart1() {
        String[] inputArray = input.split("\n");
        Map<LocalDateTime, String> orderedByDate = new HashMap<>();
        for (String s : inputArray) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.US).withResolverStyle(ResolverStyle.SMART);
            String dateString = s.substring(1, 17);
            LocalDateTime date = LocalDateTime.parse(dateString, formatter);
            orderedByDate.put(date, s.split("] ")[1]);
        }
        Map<LocalDateTime, String> treeMap = new TreeMap<>(orderedByDate);
        findSleepiestGuard(treeMap);
    }


    public void findSleepiestGuard(Map<LocalDateTime, String> treemap) {
        Map<String, Integer> sleepPatterns = new HashMap<>();
        int countMinutesAsleep = 0;
        int startSleepTime = 0;
        int wakeUpTime = 0;
        String id = null;
        List<GuardPattern> guardPatterns = new ArrayList<>();
        for (Map.Entry<LocalDateTime, String> entry : treemap.entrySet()) {
            if (entry.getValue().contains("Guard")) {
                id = entry.getValue().split(" ")[1];
                countMinutesAsleep = 0;
                startSleepTime = 0;
                wakeUpTime = 0;
            }
            if (entry.getValue().contains("falls asleep")) {
                startSleepTime = entry.getKey().getMinute();
            }
            if (entry.getValue().contains("wakes up")) {
                wakeUpTime = entry.getKey().getMinute();
            }
            if (startSleepTime != 0 && wakeUpTime != 0) {
                countMinutesAsleep = (wakeUpTime - startSleepTime);
                if (sleepPatterns.containsKey(id)) {
                    countMinutesAsleep += sleepPatterns.get(id);
                }
                sleepPatterns.put(id, countMinutesAsleep);
                GuardPattern guard = new GuardPattern(id, entry.getKey(), startSleepTime, wakeUpTime);
                guardPatterns.add(guard);
                startSleepTime = 0;
                wakeUpTime = 0;
            }
        }
        String chosenGuardId = null;
        Integer mostHoursAsleep = 0;
        for (Map.Entry<String, Integer> entry : sleepPatterns.entrySet()) {
            if (entry.getValue() > mostHoursAsleep) {
                mostHoursAsleep = entry.getValue();
                chosenGuardId = entry.getKey();
            }
        }
        System.out.println("Chosen guard: " + chosenGuardId);

        Map<String, Integer> timesAsleep = new HashMap<>();
        Map<String, Integer> guardMins = new HashMap<>();
        for (GuardPattern guard : guardPatterns) {
            if (guard.getId().equals(chosenGuardId)) {
                for (int i = guard.getStartSleep(); i <= guard.getWakeTime(); i++) {
                    String time = guard.getDate().getHour() + ":" + i;
                    if (timesAsleep.containsKey(time)) {
                        timesAsleep.put(time, timesAsleep.get(time) + 1);
                    } else {
                        timesAsleep.put(time, 1);
                    }
                }
            }
            for (int j = guard.getStartSleep(); j < guard.getWakeTime(); j++) {
                String time = guard.getId() + ":" + j;
                if (guardMins.containsKey(time)) {
                    guardMins.put(time, guardMins.get(time) + 1);
                } else {
                    guardMins.put(time, 1);
                }
            }
        }

        Integer mostTimes = 0;
        String time = null;
        for (Map.Entry<String, Integer> entry : timesAsleep.entrySet()) {
            if (entry.getValue() > mostTimes) {
                mostTimes = entry.getValue();
                time = entry.getKey();
            }
        }
        System.out.println("Minute most asleep: " + time + " " + mostTimes);

        Integer mostTimesInMin = 0;
        String guardAndMin = null;
        for (Map.Entry<String, Integer> entry : guardMins.entrySet()) {
            if (entry.getValue() > mostTimesInMin) {
                mostTimesInMin = entry.getValue();
                guardAndMin = entry.getKey();
            }
        }
        System.out.println("Guard most asleep in a minute: " + guardAndMin + " " + mostTimesInMin);
    }


    private class GuardPattern {

        String id;
        LocalDateTime date;
        int startSleep;
        int wakeTime;

        public GuardPattern(String id, LocalDateTime key, int startSleepTime, int wakeUpTime) {
            this.id = id;
            this.date = key;
            this.startSleep = startSleepTime;
            this.wakeTime = wakeUpTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public int getStartSleep() {
            return startSleep;
        }

        public void setStartSleep(int startSleep) {
            this.startSleep = startSleep;
        }

        public int getWakeTime() {
            return wakeTime;
        }

        public void setWakeTime(int wakeTime) {
            this.wakeTime = wakeTime;
        }
    }
}
