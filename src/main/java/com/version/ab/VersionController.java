package com.version.ab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class VersionController {
    private static List<Version> animalVersions = new ArrayList<>();
    private static List<Version> colorVersions = new ArrayList<>();
    private static List<Version> seasonVersions = new ArrayList<>();

    private static Map<String, List<Version>> allFeatureVersionMap = new HashMap<>();


    static {
        Version cat = new Version("cat", "cat.jpg", 0, 50);
        Version dog = new Version("dog", "dog.jpg", 51, 100);
        animalVersions.add(cat);
        animalVersions.add(dog);

        Version red = new Version("red", "red.jpg", 0, 10);
        Version blue = new Version("blue", "blue.jpg", 11, 20);
        Version green = new Version("green", "green.jpg", 21, 60);
        Version black = new Version("black", "black.jpg", 61, 100);
        colorVersions.add(red);
        colorVersions.add(blue);
        colorVersions.add(green);
        colorVersions.add(black);


        Version summer = new Version("summer", "summer.jpg", 0, 25);
        Version winter = new Version("winter", "winter.jpg", 26, 40);
        Version fall = new Version("fall", "fall.jpg", 41, 90);
        Version spring = new Version("spring", "spring.jpg", 91, 100);
        seasonVersions.add(summer);
        seasonVersions.add(winter);
        seasonVersions.add(fall);
        seasonVersions.add(spring);

        allFeatureVersionMap.put("animals", animalVersions);
        allFeatureVersionMap.put("colors", colorVersions);
        allFeatureVersionMap.put("seasons", seasonVersions);

    }


    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, List<Version>> getAllVersions() {
        return allFeatureVersionMap;
    }

    @RequestMapping(value = "/{feature}/all", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Version> getFeature(@PathVariable String name) {
        return allFeatureVersionMap.get(name);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Version> getFeatureTestVersions() {
        Map<String, Version> testFeatureVersionMap = new HashMap<>();
        getTestVersion(testFeatureVersionMap, animalVersions, "animals");
        getTestVersion(testFeatureVersionMap, colorVersions, "colors");
        getTestVersion(testFeatureVersionMap, seasonVersions, "seasons");
        return testFeatureVersionMap;
    }

    private void getTestVersion(Map<String, Version> testFeatureVersionMap, List<Version> versions, String name) {
        int randInt = randInt(1, 100);
        for (Version version : versions) {
            if (randInt >= version.getFrom() && randInt <= version.getTo()) {
                version.setActual(randInt);
                testFeatureVersionMap.put(name, version);
            }
        }
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}
