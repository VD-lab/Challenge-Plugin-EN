package me.aaron.timer.utils;

import java.util.HashMap;

public class SettingsModes {
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> menu = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> settings = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> timer = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> scoreboard = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> gamerule = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> challenge = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> other = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, SettingsItems.ItemState> projects = new HashMap<>();
    public static HashMap<SettingsItems.ItemType, Integer> ints = new HashMap<>();
    public static int startTime = 0;
    public static int currentTime = 0;
    public static double maxHP = 20;
    public static int speed = 10;
    public static int distanceToGetDamaged = 1;
    public static int probabilityToMirrorDamage = 50;
    public static int BedrockDelay = 10;
    public static int MagmaTime = 1;
    public static int LavaTime = 5;
    public static int ResetTime = 20;
}
