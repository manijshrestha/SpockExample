package com.manijshrestha.spockexample

import com.manijshrestha.spockexample.Example
import com.manijshrestha.spockexample.Helper
import org.junit.Test

//
// Generated from archetype; please customize.
//


/**
 * Tests for the {@link Helper} class.
 */
class HelperTest
    extends GroovyTestCase
{
    @Test
    void testHelp() {
        new Helper().help(new Example())
    }
}
