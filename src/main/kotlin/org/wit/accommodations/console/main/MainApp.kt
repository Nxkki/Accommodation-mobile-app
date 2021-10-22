//when MainApp is called MenuScreen is ran which will then display the users interaction options

package org.wit.accommodations.console.main

import org.wit.accommodations.console.views.MenuScreen
import tornadofx.App

class MainApp : App(MenuScreen::class)
