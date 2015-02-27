%% Machine Learning Logistic Regression for binary classification

%% Initialization
clear ; close all; clc

% Load Data
% The features are stored in a feature vector
% The label for each feature set is stored in a label vector

data = load(%path to training feature set);
X = data(:, [1,2,3,4,5]); y = data(:, 6);


%% ============ Part 2: Compute Cost and Gradient ============
% Implement the cost and gradient for logistic regression. 

%  Setup the data matrix appropriately, and add ones for the intercept term
[m, n] = size(X);

% Add intercept term to x and X_test
X = [ones(m, 1) X];

% Initialize fitting parameters
initial_theta = zeros(n + 1, 1);

% Compute and display initial cost and gradient
[cost, grad] = costFunction(initial_theta, X, y);

fprintf('Cost at initial theta (zeros): %f\n', cost);
fprintf('Gradient at initial theta (zeros): \n');
fprintf(' %f \n', grad);

fprintf('\nProgram paused. Press enter to continue.\n');
pause;


%% ============= Part 3: Optimizing using fminunc  =============
%  Using (fminunc) to find the optimal parameters theta.

%  Set options for fminunc
options = optimset('GradObj', 'on', 'MaxIter', 500);

%  Run fminunc to obtain the optimal theta
%  This function will return theta and the cost 
[theta, cost] = ...
	fminunc(@(t)(costFunction(t, X, y)), initial_theta, options);

% Print theta to screen
fprintf('Cost at theta found by fminunc: %f\n', cost);
fprintf('theta: \n');
fprintf(' %f \n', theta);


%% ============== Part 4: Predict and Accuracies ==============
% Predicting the outcome of test data

testdata = load(%path to test feature set);
W = testdata(:, [1,2,3,4,5]);

[o,q] = size(W);
d = 0;

for i=1:o
	prob = sigmoid([1 W([i],[1,2,3,4,5])] * theta);

	%change inequality sign to match detection
	%testing probability of negative class <=
	%testing probability of negative class >=

	if prob >= 0.5
		d = d+1;
	end

end


% Compute accuracy on our training set

fprintf('total number of predictions: %f\n', o);
fprintf('number of correct predictions: %f\n', d);
fprintf('accuracy in percentage: %f\n', (d/o)*100 );

fprintf('\nProgram paused. Press enter to continue.\n');
pause;