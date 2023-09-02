/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.hyracks.storage.am.btree.dataflow;

import org.apache.hyracks.api.dataflow.value.IBinaryComparatorFactory;
import org.apache.hyracks.api.dataflow.value.ITypeTraits;
import org.apache.hyracks.api.io.FileReference;
import org.apache.hyracks.storage.am.common.api.IPageManagerFactory;
import org.apache.hyracks.storage.common.IResource;
import org.apache.hyracks.storage.common.IResourceFactory;
import org.apache.hyracks.storage.common.IStorageManager;

public class BTreeResourceFactory implements IResourceFactory {

    private static final long serialVersionUID = 1L;
    private final IStorageManager storageManager;
    private final ITypeTraits[] typeTraits;
    private final IBinaryComparatorFactory[] comparatorFactories;
    private final IPageManagerFactory pageManagerFactory;

    public BTreeResourceFactory(IStorageManager storageManager, ITypeTraits[] typeTraits,
            IBinaryComparatorFactory[] comparatorFactories, IPageManagerFactory pageManagerFactory) {
        this.storageManager = storageManager;
        this.typeTraits = typeTraits;
        this.comparatorFactories = comparatorFactories;
        this.pageManagerFactory = pageManagerFactory;
    }

    @Override
    public IResource createResource(FileReference fileRef) {
        return new BTreeResource(fileRef.getRelativePath(), storageManager, typeTraits, comparatorFactories,
                pageManagerFactory);
    }

}
