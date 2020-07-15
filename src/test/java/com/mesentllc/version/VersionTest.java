package com.mesentllc.version;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class VersionTest {
    private static final String errorVersionMustNotBeNull = "'version' must not be null!";
    private static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    private static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";

    class Version {
        private String[] elements = {null, null, null, ""};

        Version(String version) {
            Pattern pattern = Pattern.compile("^(\\d)(\\.(\\d+)){0,1}(\\.(\\d+)){0,1}(-SNAPSHOT){0,1}$");
            if (version == null) {
                throw new IllegalArgumentException(errorVersionMustNotBeNull);
            }
            if (!pattern.matcher(version).matches()) {
                throw new IllegalArgumentException(errorVersionMustMatchPattern);
            }
            String[] split = version.split("[.-]");
            boolean snapshot = isSnapshot(version);
            int counter = split.length;
            if (snapshot) {
                counter--;
            }
            int internal = 0;
            for (int ptr = 0; ptr < counter; ptr++) {
                elements[ptr] = split[internal++];
            }
            for (int ptr = internal; ptr < 3; ptr++) {
                elements[ptr] = "0";
            }
            if (snapshot) {
                elements[3] = "-SNAPSHOT";
            }
        }

        private boolean isSnapshot(String version) {
            return version.endsWith("-SNAPSHOT");
        }

        @Override
        public String toString() {
            return String.format("%s.%s.%s%s", elements[0], elements[1], elements[2], elements[3]);
        }

        int compareTo(Version other) {
            if (other == null) {
                throw new IllegalArgumentException(errorOtherMustNotBeNull);
            }
            if (isSnapshot(toString()) == other.isSnapshot(other.toString())) {
                return toString().compareTo(other.toString());
            }
            if (isSnapshot(toString())) {
                String trunc = toString();
                return trunc.substring(0, trunc.length() - 9).compareTo(other.toString());
            }
            String trunc = other.toString();
            return toString().compareTo(trunc.substring(0, trunc.length() - 9));
        }
    }

    @Test
    public void constructor_null_exception() {
        try {
            new Version(null);
        } catch (IllegalArgumentException iae) {
            Assert.assertEquals(errorVersionMustNotBeNull, iae.getMessage());
        }
    }

    @Test
    public void constructor_badVersion_exception() {
        try {
            new Version("4.6.R");
        } catch (IllegalArgumentException iae) {
            Assert.assertEquals(errorVersionMustMatchPattern, iae.getMessage());
        }
    }

    @Test
    public void constructor_valid() {
        Version version = new Version("3.8.0");
        Assert.assertEquals("3.8.0", version.toString());
    }

    @Test
    public void constructor_validSnapshot() {
        Version version = new Version("3.8.0-SNAPSHOT");
        Assert.assertEquals("3.8.0-SNAPSHOT", version.toString());
    }

    @Test
    public void constructor_onlyMajor_minorAndVersionSetToZero() {
        Version version = new Version("3");
        Assert.assertEquals("3.0.0", version.toString());
    }

    @Test
    public void constructor_onlyMajorSnapshot_minorAndVersionSetToZeroSnapshot() {
        Version version = new Version("3-SNAPSHOT");
        Assert.assertEquals("3.0.0-SNAPSHOT", version.toString());
    }

    @Test
    public void constructor_onlyMajorAndMinor_minorAndVersionSetToZero() {
        Version version = new Version("3.7");
        Assert.assertEquals("3.7.0", version.toString());
    }

    @Test
    public void constructor_onlyMajorAndMinorSnapshot_minorAndVersionSetToZeroSnapshot() {
        Version version = new Version("3.7-SNAPSHOT");
        Assert.assertEquals("3.7.0-SNAPSHOT", version.toString());
    }

    @Test
    public void compareTo_null_exception() {
        Version version = new Version("4.3.9");
        try {
            version.compareTo(null);
        } catch (IllegalArgumentException iae) {
            Assert.assertEquals(errorOtherMustNotBeNull, iae.getMessage());
        }
    }

    @Test
    public void compareTo_firstVersionsLessThan_lessReturned() {
        Assert.assertEquals(-1, new Version("1.2.2").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_versionsEqual_equalReturned() {
        Assert.assertEquals(0, new Version("1.2.3").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_firstVersionsMoreThan_moreReturned() {
        Assert.assertEquals(2, new Version("1.2.5").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_firstSnapshotVersionLessThan_lessReturned() {
        Assert.assertEquals(-1, new Version("1.2.2-SNAPSHOT").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_versionEqualBuSnapshot_lessReturned() {
        Assert.assertEquals(0, new Version("1.2.3-SNAPSHOT").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_firstVersionSnapshotMoreThan_moreReturned() {
        Assert.assertEquals(2, new Version("1.2.5-SNAPSHOT").compareTo(new Version("1.2.3")));
    }

    @Test
    public void compareTo_secondSnapshotVersionMoreThan_lessReturned() {
        Assert.assertEquals(-1, new Version("1.2.2").compareTo(new Version("1.2.3-SNAPSHOT")));
    }

    @Test
    public void compareTo_secondEqualBuSnapshot_moreReturned() {
        Assert.assertEquals(0, new Version("1.2.3").compareTo(new Version("1.2.3-SNAPSHOT")));
    }

    @Test
    public void compareTo_secondVersionSnapshotLessThan_moreReturned() {
        Assert.assertEquals(2, new Version("1.2.5").compareTo(new Version("1.2.3-SNAPSHOT")));
    }
}


