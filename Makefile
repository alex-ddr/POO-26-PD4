JAVAC = javac
JAVA = java
SRC_DIR = src
BUILD_DIR = out
LIB_DIR = lib
MAIN_CLASS = MainFILEY

SOURCES = $(wildcard $(SRC_DIR)/datos/*.java) \
          $(wildcard $(SRC_DIR)/bd/*.java) \
          $(wildcard $(SRC_DIR)/mvc/*.java) \
          $(SRC_DIR)/$(MAIN_CLASS).java

.PHONY: all compile run clean

all: run

compile:
	$(JAVAC) -encoding UTF-8 -cp "$(LIB_DIR)/*" -d $(BUILD_DIR) $(SOURCES)

run: compile
	$(JAVA) -cp "$(BUILD_DIR):$(LIB_DIR)/*" $(MAIN_CLASS)

clean:
	rm -rf $(BUILD_DIR)