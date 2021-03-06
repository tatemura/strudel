/*******************************************************************************
 * Copyright 2015, 2016 Junichi Tatemura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.nec.strudel.workload.measure.jmx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.nec.strudel.Closeable;
import com.nec.strudel.exceptions.WorkloadException;

public class JmxCluster implements Closeable {
    private final List<JMXServiceURL> urls;
    private final List<JMXConnector> jmxcs = new ArrayList<JMXConnector>();

    public JmxCluster(List<JMXServiceURL> urls) {
        this.urls = urls;
    }

    public List<MBeanServerConnection> open() throws IOException {
        List<MBeanServerConnection> cons = new ArrayList<MBeanServerConnection>();
        for (JMXServiceURL url : urls) {
            JMXConnector jmxc = JMXConnectorFactory.connect(url);
            cons.add(jmxc.getMBeanServerConnection());
            jmxcs.add(jmxc);
        }
        return cons;
    }

    public int size() {
        return urls.size();
    }

    @Override
    public void close() {
        for (JMXConnector jmxc : jmxcs) {
            try {
                jmxc.close();
            } catch (IOException ex) {
                throw new WorkloadException(
                        "failed to close JMX connector", ex);
            }
        }
    }

    @Override
    public int hashCode() {
        return urls.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JmxCluster) {
            JmxCluster cluster = (JmxCluster) obj;
            return urls.equals(cluster.urls);
        }
        return false;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<JMXServiceURL> urls = new ArrayList<JMXServiceURL>();

        public JmxCluster build() {
            return new JmxCluster(urls);
        }

        public Builder url(String url) {
            try {
                JMXServiceURL serviceUrl = new JMXServiceURL(url);
                urls.add(serviceUrl);
            } catch (MalformedURLException ex) {
                throw new RuntimeException("malformed URL:"
                        + url, ex);
            }
            return this;
        }

        public Builder host(String host, int port) {
            String url = new StringBuilder()
                    .append("service:jmx:rmi:///jndi/rmi://")
                    .append(host).append(":").append(port)
                    .append("/jmxrmi")
                    .toString();
            return url(url);
        }

        public Builder host(String host) {
            String url = new StringBuilder()
                    .append("service:jmx:rmi:///jndi/rmi://")
                    .append(host)
                    .append("/jmxrmi")
                    .toString();
            return url(url);
        }
    }
}
