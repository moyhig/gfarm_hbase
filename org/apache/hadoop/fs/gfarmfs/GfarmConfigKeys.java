/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.fs.gfarmfs;

import java.io.IOException;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;
import org.apache.hadoop.fs.CommonConfigurationKeys;
import org.apache.hadoop.fs.FsServerDefaults;
import org.apache.hadoop.util.DataChecksum;

/** 
 * This class contains constants for configuration keys used
 * in the local file system, raw local fs and checksum fs.
 */
@InterfaceAudience.Private
@InterfaceStability.Unstable
public class GfarmConfigKeys extends CommonConfigurationKeys {

  public static final String BLOCK_SIZE_KEY = "gfarm.blocksize";
  public static final long BLOCK_SIZE_DEFAULT = 64*1024*1024;
  public static final String  REPLICATION_KEY = "gfarm.replication";
  public static final short REPLICATION_DEFAULT = 3;
  public static final String STREAM_BUFFER_SIZE_KEY = "gfarm.stream-buffer-size";
  public static final int STREAM_BUFFER_SIZE_DEFAULT = 4096;
  public static final String BYTES_PER_CHECKSUM_KEY = "gfarm.bytes-per-checksum";
  public static final int BYTES_PER_CHECKSUM_DEFAULT = 512;
  public static final String CLIENT_WRITE_PACKET_SIZE_KEY =
                                                "gfarm.client-write-packet-size";
  public static final int CLIENT_WRITE_PACKET_SIZE_DEFAULT = 64*1024;
  public static final boolean ENCRYPT_DATA_TRANSFER_DEFAULT = false;
  public static final long FS_TRASH_INTERVAL_DEFAULT = 0;
  public static final int CHECKSUM_TYPE_DEFAULT = DataChecksum.CHECKSUM_CRC32;
  public static FsServerDefaults getServerDefaults() throws IOException {
    return new FsServerDefaults(
        BLOCK_SIZE_DEFAULT,
        BYTES_PER_CHECKSUM_DEFAULT,
        CLIENT_WRITE_PACKET_SIZE_DEFAULT,
        REPLICATION_DEFAULT,
        STREAM_BUFFER_SIZE_DEFAULT,
        ENCRYPT_DATA_TRANSFER_DEFAULT,
        FS_TRASH_INTERVAL_DEFAULT,
        CHECKSUM_TYPE_DEFAULT);
  }
}
