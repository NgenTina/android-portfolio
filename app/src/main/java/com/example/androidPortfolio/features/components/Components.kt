package com.example.androidPortfolio.features.components

data class ComponentCategoryItem(
    val id: String,
    val title: String,
    val description: String
)

data class ComponentItem(
    val id: String,
    val title: String,
    val description: String
)

val componentCategories = listOf(
    ComponentCategoryItem(
        id = "buttons",
        title = "Buttons",
        description = "Filled, tonal, elevated, outlined, text, and segmented buttons."
    ),
    ComponentCategoryItem(
        id = "dialogs",
        title = "Dialogs",
        description = "Alerts, confirmation dialogs, and full screen dialogs."
    ),
    ComponentCategoryItem(
        id = "progressIndicators",
        title = "Progress Indicators",
        description = "Circular and linear loading indicators."
    ),
    ComponentCategoryItem(
        id = "appbars",
        title = "App Bars",
        description = "Top app bars, badged icons, and navigation bars."
    ),
    ComponentCategoryItem(
        id = "bottomSheets",
        title = "Bottom Sheets",
        description = "Modal and partially expanded bottom sheets."
    ),
    ComponentCategoryItem(
        id = "menu",
        title = "Menus",
        description = "Dropdown menus and option lists."
    ),
    ComponentCategoryItem(
        id = "navigationBar",
        title = "Bottom Navigation Bar",
        description = "NavigationBar with items and selection states."
    ),
    ComponentCategoryItem(
        id = "navigationDrawer",
        title = "Navigation Drawer",
        description = "Modal navigation drawer with sections and items."
    ),
    ComponentCategoryItem(
        id = "radios",
        title = "Radio Buttons",
        description = "Radio button selection groups and scrollable radio lists."
    )
)

val componentsByCategory: Map<String, List<ComponentItem>> = mapOf(
    "buttons" to listOf(
        ComponentItem(
            id = "button",
            title = "Filled Button",
            description = "High-emphasis button for primary actions."
        ),
        ComponentItem(
            id = "filledTonalButton",
            title = "Filled Tonal Button",
            description = "Medium-emphasis button for secondary actions."
        ),
        ComponentItem(
            id = "elevatedButton",
            title = "Elevated Button",
            description = "Button with a shadow elevation."
        ),
        ComponentItem(
            id = "outlinedButton",
            title = "Outlined Button",
            description = "Medium-emphasis button with an outline border."
        ),
        ComponentItem(
            id = "textButton",
            title = "Text Button",
            description = "Low-emphasis button without borders or background."
        ),
        ComponentItem(
            id = "segmentedButton",
            title = "Segmented Button",
            description = "Single choice option row."
        )
    ),
    "dialogs" to listOf(
        ComponentItem(
            id = "alertDialog",
            title = "Alert Dialog",
            description = "Displays a message and asks the user to respond."
        ),
        ComponentItem(
            id = "fullScreenDialog",
            title = "Full Screen Dialog",
            description = "Covers the whole screen for complex tasks."
        )
    ),
    "progressIndicators" to listOf(
        ComponentItem(
            id = "circularProgressIndicator",
            title = "Circular Progress Indicator",
            description = "Shows loading progress using a circular spinner."
        ),
        ComponentItem(
            id = "linearProgressIndicator",
            title = "Linear Progress Indicator",
            description = "Shows progress along a horizontal line track."
        )
    ),
    "appbars" to listOf(
        ComponentItem(
            id = "centerAlignedTopAppBar",
            title = "Center-Aligned Top App Bar",
            description = "Top app bar with centered title and action badges."
        )
    ),
    "bottomSheets" to listOf(
        ComponentItem(
            id = "modalBottomSheet",
            title = "Modal Bottom Sheet",
            description = "Sheet overlay sliding up from screen bottom."
        ),
        ComponentItem(
            id = "partialBottomSheet",
            title = "Partial Bottom Sheet",
            description = "Bottom sheet supporting partial expansion states."
        )
    ),
    "menu" to listOf(
        ComponentItem(
            id = "dropdownMenu",
            title = "Dropdown Menu",
            description = "Contextual menu displaying selectable items."
        )
    ),
    "navigationBar" to listOf(
        ComponentItem(
            id = "bottomNavigationBar",
            title = "Bottom Navigation Bar",
            description = "Material 3 bottom navigation bar with icons and labels."
        )
    ),
    "navigationDrawer" to listOf(
        ComponentItem(
            id = "modalNavigationDrawer",
            title = "Modal Navigation Drawer",
            description = "Side navigation drawer containing app sections."
        )
    ),
    "radios" to listOf(
        ComponentItem(
            id = "radioButton",
            title = "Radio Button Group",
            description = "Standard single-selection radio button options."
        ),
        ComponentItem(
            id = "scrollRadio",
            title = "Scrollable Radio List",
            description = "Radio selection inside a scrollable list view."
        )
    )
)
