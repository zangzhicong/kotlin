// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: compiler/ir/serialization.common/src/KotlinIr.proto

package org.jetbrains.kotlin.backend.common.serialization.proto;

public interface FileEntryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:org.jetbrains.kotlin.backend.common.serialization.proto.FileEntry)
    org.jetbrains.kotlin.protobuf.MessageLiteOrBuilder {

  /**
   * <code>required string name = 1;</code>
   */
  boolean hasName();
  /**
   * <code>required string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <code>required string name = 1;</code>
   */
  org.jetbrains.kotlin.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated int32 line_start_offset = 2 [packed = true];</code>
   */
  java.util.List<java.lang.Integer> getLineStartOffsetList();
  /**
   * <code>repeated int32 line_start_offset = 2 [packed = true];</code>
   */
  int getLineStartOffsetCount();
  /**
   * <code>repeated int32 line_start_offset = 2 [packed = true];</code>
   */
  int getLineStartOffset(int index);

  /**
   * <code>optional int32 first_relevant_line_index = 3 [default = 0];</code>
   */
  boolean hasFirstRelevantLineIndex();
  /**
   * <code>optional int32 first_relevant_line_index = 3 [default = 0];</code>
   */
  int getFirstRelevantLineIndex();
}